package com.sparta.schedulemanager_extension.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentCreateRequestDto extends CommentBaseRequestDto {
    private int scheduleId;
    private String userName;
}
