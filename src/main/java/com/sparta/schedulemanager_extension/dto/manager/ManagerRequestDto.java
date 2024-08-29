package com.sparta.schedulemanager_extension.dto.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ManagerRequestDto {
    private int scheduleId;
    private int userId;
    private int requester;
}
