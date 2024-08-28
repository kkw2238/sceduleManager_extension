package com.sparta.schedulemanager_extension.service;

import com.sparta.schedulemanager_extension.dto.schedule.ScheduleBaseRequestDto;
import com.sparta.schedulemanager_extension.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.schedulemanager_extension.dto.schedule.ScheduleResponseDto;
import com.sparta.schedulemanager_extension.entity.Schedule;
import com.sparta.schedulemanager_extension.repository.ScheduleRepository;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

    ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    /**
     * @param scheduleCreateRequestDto RequestBody로 들어온 스케쥴 정보
     * @return 저장된 내용
     */
    public ScheduleResponseDto createSchedule(ScheduleCreateRequestDto scheduleCreateRequestDto) {
        Schedule schedule = scheduleCreateRequestDto.convertSchedule();
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule);
    }

    /**
     * @param scheduleId 조회하고자 하는 스케쥴 아이디
     * @return 조회된 스케쥴 내용이 담긴 객체
     */
    public ScheduleResponseDto getSchedule(Integer scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() ->
                new RuntimeException("Schedule not found"));

        return new ScheduleResponseDto(schedule);
    }

    /**
     * @param scheduleId 변경하고자 하는 스케쥴 아이디
     * @param scheduleBaseRequestDto 변경하고자 하는 내용( 제목, 내용 )
     * @return 업데이트 된 일정 내용
     */
    public ScheduleResponseDto updateSchedule(Integer scheduleId, ScheduleBaseRequestDto scheduleBaseRequestDto) {
        Schedule foundSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new RuntimeException("Schedule not found")
        );
        foundSchedule.updateSchedule(scheduleBaseRequestDto.getScheduleTitle(), scheduleBaseRequestDto.getScheduleData());

        Schedule updatedSchedule = scheduleRepository.save(foundSchedule);
        return new ScheduleResponseDto(updatedSchedule);
    }
}
