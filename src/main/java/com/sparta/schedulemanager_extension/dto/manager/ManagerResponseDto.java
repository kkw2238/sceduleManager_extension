package com.sparta.schedulemanager_extension.dto.manager;

import com.sparta.schedulemanager_extension.entity.Manager;
import lombok.Getter;

@Getter
public class ManagerResponseDto {
    private int scheduleId;
    private int userId;

    public ManagerResponseDto(Manager manager) {
        this.scheduleId = manager.getScheduleId().getId();
        this.userId = manager.getUserId().getId();
    }
}
