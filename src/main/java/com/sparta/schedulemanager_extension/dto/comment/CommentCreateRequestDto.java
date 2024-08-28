package com.sparta.schedulemanager_extension.dto.comment;

import com.sparta.schedulemanager_extension.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentCreateRequestDto extends CommentBaseRequestDto {
    private int scheduleId;
    private String userName;
}
