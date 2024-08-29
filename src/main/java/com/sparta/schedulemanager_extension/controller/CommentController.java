package com.sparta.schedulemanager_extension.controller;

import com.sparta.schedulemanager_extension.dto.comment.CommentBaseRequestDto;
import com.sparta.schedulemanager_extension.dto.comment.CommentCreateRequestDto;
import com.sparta.schedulemanager_extension.dto.comment.CommentResponseDto;
import com.sparta.schedulemanager_extension.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    final CommentService commentService;

    CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * @param commentCreateRequestDto 코멘트 제목, 내용이 담긴 RequestBody
     * @return 생성된 코멘트 정보가 담긴 객체
     */
    @PostMapping("/comments")
    public CommentResponseDto createComment(@RequestBody CommentCreateRequestDto commentCreateRequestDto) {
        return commentService.createComment(commentCreateRequestDto);
    }

    /**
     * @param commentsId 조회하고자 하는 코멘트 ID
     * @return 조회된 코멘트의 내용이 담긴 객체
     */
    @GetMapping("/comments/{commentsId}")
    public CommentResponseDto getComment(@PathVariable Integer commentsId) {
        return commentService.getComment(commentsId);
    }

    /**
     * @return 조회된 코멘트의 내용이 담긴 객체
     */
    @GetMapping("/comments")
    public List<CommentResponseDto> getAllComment() {
        return commentService.getAllComment();
    }

    /**
     * @param commentsId 갱신하고자 하는 코멘트의 ID
     * @param commentBaseRequestDto 갱신할 내용이 담긴 RequestBody
     * @return 갱신후 코멘트 내용이 담긴 객체
     */
    @PutMapping("/comments/{commentsId}")
    public CommentResponseDto updateComment(@PathVariable Integer commentsId, @RequestBody CommentBaseRequestDto commentBaseRequestDto) {
        return commentService.updateComment(commentsId, commentBaseRequestDto);
    }

    /**
     * @param commentsId 삭제하고자 하는 코멘트의 Id
     * @return 삭제한 코멘트의 Id
     */
    @DeleteMapping("/comments/{commentsId}")
    public Integer deleteComment(@PathVariable Integer commentsId) {
        return commentService.deleteComment(commentsId);
    }
}
