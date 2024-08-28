package com.sparta.schedulemanager_extension.controller;

import com.sparta.schedulemanager_extension.dto.ScheduleBaseRequestDto;
import com.sparta.schedulemanager_extension.dto.ScheduleCreateRequestDto;
import com.sparta.schedulemanager_extension.dto.ScheduleResponseDto;
import com.sparta.schedulemanager_extension.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @param scheduleId 조회하고자 하는 스케쥴 ID
     * @return 조회된 스케쥴 내용이 담긴 객체
     */
    @GetMapping("/schedules/{scheduleId}")
    public ScheduleResponseDto getSchedule(@PathVariable Integer scheduleId) {
        return scheduleService.getSchedule(scheduleId);
    }

    /**
     * @param scheduleId 갱신하고자 하는 스케쥴 ID
     * @param scheduleBaseRequestDto 갱신할 내용이 담긴 RequestBody
     * @return 갱신후 스케쥴 내용이 담긴 객체
     */
    @PutMapping("/schedules/{scheduleId}")
    public ScheduleResponseDto updateSchedule(@PathVariable Integer scheduleId, @RequestBody ScheduleBaseRequestDto scheduleBaseRequestDto) {
        return scheduleService.updateSchedule(scheduleId, scheduleBaseRequestDto);
    }
}
