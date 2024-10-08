package com.sparta.schedulemanager_extension.dto.user;

import com.sparta.schedulemanager_extension.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto extends UserBaseResponseDto {

    private String createDateTime;
    private String editDateTime;

    public UserResponseDto(User user) {
        userId = user.getId();
        userName = user.getUserName();
        email = user.getEmail();
        createDateTime = user.getCreateDateTime();
        editDateTime = user.getEditDateTime();
    }
}
