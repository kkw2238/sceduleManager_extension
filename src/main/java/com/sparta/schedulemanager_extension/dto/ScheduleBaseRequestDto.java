package com.sparta.schedulemanager_extension.dto;

import com.sparta.schedulemanager_extension.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

/**
 *  스케쥴 관련 쿼리 ( 삽입, 수정 ) 공통으로 들어가야할 내용이 담긴 Dto
 */
@Setter
@Getter
public class ScheduleBaseRequestDto {
    protected String scheduleTitle;
    protected String scheduleData;

    public Schedule convertSchedule() {
        return new Schedule(scheduleTitle, scheduleData, null);
    }
}
