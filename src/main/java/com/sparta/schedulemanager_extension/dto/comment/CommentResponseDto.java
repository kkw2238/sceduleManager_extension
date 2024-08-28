package com.sparta.schedulemanager_extension.dto.comment;

import com.sparta.schedulemanager_extension.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentResponseDto {
    int commentId;
    int scheduleId;
    String commentData;
    String userName;
    String createDateTime;
    String editDateTime;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getId();
        this.scheduleId = comment.getSchedule().getId();
        this.commentData = comment.getCommentData();
        this.userName = comment.getUserName();
        this.createDateTime = comment.getCreateDateTime();
        this.editDateTime = comment.getEditDateTime();
    }
}
