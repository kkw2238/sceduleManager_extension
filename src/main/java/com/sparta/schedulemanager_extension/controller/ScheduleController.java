package com.sparta.schedulemanager_extension.controller;

import com.sparta.schedulemanager_extension.dto.schedule.*;
import com.sparta.schedulemanager_extension.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    final ScheduleService scheduleService;

    ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /**
     * @param scheduleCreateRequestDto 스케쥴 제목, 내용이 담긴 RequestBody
     * @return 생성된 스케쥴 정보가 담긴 객체
     */
    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleCreateRequestDto scheduleCreateRequestDto) {
        return scheduleService.createSchedule(scheduleCreateRequestDto);
    }

    /** scheduleId에 해당하는 schedule을 조회하는 함수
     *
     * @param scheduleId 조회하고자 하는 스케쥴 ID
     * @return 조회된 스케쥴 내용이 담긴 객체
     */
    @GetMapping("/schedules/{scheduleId}")
    public ScheduleSingleCaseResponseDto getSchedule(@PathVariable Integer scheduleId) {
        return scheduleService.getSchedule(scheduleId);
    }

    /** 모든 스케쥴에 대해 페이징한 결과를 반환하는 함수
     *
     * @param page 페이징 할 인덱스
     * @param size 페이징 사이즈 Default : 10개
     * @return 조회 & 댓글 수까지 추가된 객체
     */
    @GetMapping("/schedules")
    public List<SchedulePageResponseDto> getPageSchedules(
            @RequestParam Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        return scheduleService.getPageSchedules(page, size);
    }
    /** schedule Id에 해당하는 스케쥴을 업데이트 하는 함수
     *
     * @param scheduleId 갱신하고자 하는 스케쥴 ID
     * @param scheduleBaseRequestDto 갱신할 내용이 담긴 RequestBody
     * @return 갱신후 스케쥴 내용이 담긴 객체
     */
    @PutMapping("/schedules/{scheduleId}")
    public ScheduleResponseDto updateSchedule(@PathVariable Integer scheduleId, @RequestBody ScheduleBaseRequestDto scheduleBaseRequestDto) {
        return scheduleService.updateSchedule(scheduleId, scheduleBaseRequestDto);
    }

    /** schedule ID에 해당하는 스케쥴을 삭제하는 함수
     *
     * @param scheduleId 삭제하고자 하는 스케쥴 ID
     * @return 삭제된 스케쥴 ID
     */
    @DeleteMapping("/schedules/{scheduleId}")
    public Integer deleteSchedule(@PathVariable Integer scheduleId) {
        return scheduleService.deleteSchedule(scheduleId);
    }
}
