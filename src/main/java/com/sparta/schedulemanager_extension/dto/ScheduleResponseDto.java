package com.sparta.schedulemanager_extension.dto;

import com.sparta.schedulemanager_extension.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleResponseDto {
    int scheduleID;
    String scheduleTitle;
    String scheduleData;
    String createDateTime;
    String editDateTime;
    String managerName;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleID = schedule.getId();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleData = schedule.getScheduleData();
        this.createDateTime = schedule.getCreateDateTime();
        this.editDateTime = schedule.getEditDateTime();
        this.managerName = schedule.getManegerName();
    }
}
