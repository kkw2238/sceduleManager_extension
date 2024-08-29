package com.sparta.schedulemanager_extension.service;

import com.sparta.schedulemanager_extension.dto.manager.ManagerRequestDto;
import com.sparta.schedulemanager_extension.dto.manager.ManagerResponseDto;
import com.sparta.schedulemanager_extension.entity.Manager;
import com.sparta.schedulemanager_extension.entity.Schedule;
import com.sparta.schedulemanager_extension.entity.User;
import com.sparta.schedulemanager_extension.repository.ManagerRepository;
import com.sparta.schedulemanager_extension.repository.ScheduleRepository;
import com.sparta.schedulemanager_extension.repository.UserRespository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerService {
    final ManagerRepository managerRepository;
    final ScheduleRepository scheduleRepository;
    final UserRespository userRespository;

    public ManagerService(ManagerRepository managerRepository,
                          ScheduleRepository scheduleRepository,
                          UserRespository userRespository) {
        this.managerRepository = managerRepository;
        this.scheduleRepository = scheduleRepository;
        this.userRespository = userRespository;
    }

    /** 스케쥴에 매니져를 추가하는 메서드
     *
     * @param managerRequestDto 매니져를 추가할 스케쥴 Id, 유저 Id, 요청자 Id를 담은 객체
     * @return 해당 스케쥴에 참여하고 있는 모든 유저 Id
     */
    public List<ManagerResponseDto> addManager(ManagerRequestDto managerRequestDto) {
        // 해당 스케쥴이 존재하고 있는지 확인
        Schedule schedule = scheduleRepository.findById(managerRequestDto.getScheduleId()).orElseThrow(
                () -> new RuntimeException("Schedule not found")
        );

        checkAttendAble(schedule, managerRequestDto);

        // 해당 유저가 실존하는지 확인
        User user = userRespository.findById(managerRequestDto.getUserId()).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        // 실존할 경우 Manager를 생성하고 추가
        Manager manager = new Manager(user, schedule);
        managerRepository.save(manager);

        return getManagersAtSchedule(schedule).stream().map(ManagerResponseDto::new).toList();
    }

    /** 해당 스케쥴에 투입된 모든 매니저 정보를 반환하는 메서드
     *
     * @param schedule 관련 스케쥴
     * @return 해당 스케쥴에 투입된 모든 매니저 정보
     */
    public List<Manager> getManagersAtSchedule(Schedule schedule) {
        return managerRepository.findAllByscheduleId(schedule);
    }

    /** 해당 스케쥴에 요청이 수락될 수 있는지 확인하는 메서드
     *
     * @param schedule 투입될 스케쥴 정보
     * @param managerRequestDto 사용자가 전송한 매니저 요청 정보
     */
    private void checkAttendAble(Schedule schedule, ManagerRequestDto managerRequestDto) {
        // 새로운 유저가 이미 투입되어 있는지 확인
        if(isAlreadyAttending(managerRequestDto.getUserId(), schedule)) {
            throw new RuntimeException("Manager already exists");
        }

        // 스케쥴의 작성자와 요청자가 일치하는지 확인
        if(schedule.getWriter() != managerRequestDto.getRequester()) {
            throw new RuntimeException("Requester is not the same");
        }
    }

    /** 해당 유저가 이미 스케쥴에 투입되어 있는지 확인하는 메서드
     *
     * @param userId 투입되고자 하는 유저
     * @param schedule 투입될 스케쥴
     * @return 중복 투입 여부
     */
    private boolean isAlreadyAttending(int userId, Schedule schedule) {
        for (Manager manager : schedule.getManagers()) {
            if (manager.getUserId().getId() == userId) {
                return true;
            }
        }

        return false;
    }
}
