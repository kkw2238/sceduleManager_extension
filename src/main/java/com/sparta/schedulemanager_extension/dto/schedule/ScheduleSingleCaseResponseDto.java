package com.sparta.schedulemanager_extension.dto.schedule;

import com.sparta.schedulemanager_extension.dto.user.UserBaseResponseDto;
import com.sparta.schedulemanager_extension.entity.Schedule;
import com.sparta.schedulemanager_extension.entity.User;
import lombok.Getter;

import java.util.List;

@Getter
public class ScheduleSingleCaseResponseDto extends ScheduleResponseDto {
    protected List<UserBaseResponseDto> userBaseResponseDtos;

    public ScheduleSingleCaseResponseDto(Schedule schedule) {
        super(schedule);

        userBaseResponseDtos = schedule.getManagers().stream().map(UserBaseResponseDto::new).toList();
    }
}
