package com.sparta.schedulemanager_extension.dto.user;

import com.sparta.schedulemanager_extension.entity.Manager;
import com.sparta.schedulemanager_extension.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserBaseResponseDto {
    protected int userId;
    protected String userName;
    protected String email;

    public UserBaseResponseDto(Manager manager) {
        this.userId = manager.getUserId().getId();
        this.userName = manager.getUserId().getUserName();
        this.email = manager.getUserId().getEmail();
    }
}
