package com.sparta.schedulemanager_extension.dto.schedule;

import com.sparta.schedulemanager_extension.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

/**
 *  스케쥴 관련 쿼리 중 생성과 관련된 정보가 담긴 Dto
 */
@Setter
@Getter
public class ScheduleCreateRequestDto extends ScheduleBaseRequestDto {
    protected String managerName;

    @Override
    public Schedule convertSchedule() {
        return new Schedule(scheduleTitle, scheduleData, managerName);
    }
}