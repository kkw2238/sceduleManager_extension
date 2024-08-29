package com.sparta.schedulemanager_extension.dto.schedule;

import com.sparta.schedulemanager_extension.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 페이징 정보가 담기는 객체 / 기존 ResponseDto에서 댓글 수가 추가 됐다.
 */
@Getter
@AllArgsConstructor
public class SchedulePageResponseDto extends ScheduleResponseDto {
    int commentCount;

    public SchedulePageResponseDto(Schedule schedule) {
        super(schedule);

        commentCount = schedule.getComments().size();
    }
}
