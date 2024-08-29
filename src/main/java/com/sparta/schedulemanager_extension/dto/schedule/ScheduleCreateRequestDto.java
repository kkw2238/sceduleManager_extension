package com.sparta.schedulemanager_extension.dto.schedule;

import com.sparta.schedulemanager_extension.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  스케쥴 관련 쿼리 중 생성과 관련된 정보가 담긴 Dto
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ScheduleCreateRequestDto extends ScheduleBaseRequestDto {
    protected int userId;
    
    @Override
    public Schedule convertSchedule() {
        return new Schedule(scheduleTitle, scheduleData, userId);
    }
}