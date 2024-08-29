package com.sparta.schedulemanager_extension.service;

import com.sparta.schedulemanager_extension.dto.comment.CommentBaseRequestDto;
import com.sparta.schedulemanager_extension.dto.comment.CommentCreateRequestDto;
import com.sparta.schedulemanager_extension.dto.comment.CommentResponseDto;
import com.sparta.schedulemanager_extension.entity.Comment;
import com.sparta.schedulemanager_extension.entity.Schedule;
import com.sparta.schedulemanager_extension.repository.CommentRepository;
import com.sparta.schedulemanager_extension.repository.ScheduleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentService {
    final CommentRepository commentRepository;
    final ScheduleRepository scheduleRepository;

    CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    /** comment 추가하는 함수
     *
     * @param commentCreateRequestDto 추가하고자 하는 Comment정보가 담긴 객체
     * @return DB에 저장된 내용
     */
    public CommentResponseDto createComment(CommentCreateRequestDto commentCreateRequestDto) {
        Schedule schedule = scheduleRepository.findById(commentCreateRequestDto.getScheduleId()).orElseThrow(
                () -> new RuntimeException("Schedule not found"));

        Comment comment = new Comment(commentCreateRequestDto, schedule);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }

    /** commentID에 해당하는 코멘트를 조회하는 함수
     *
     * @param commentsId 조회하고자 하는 코멘트 Id
     * @return 조회된 코멘트 정보
     */
    public CommentResponseDto getComment(Integer commentsId) {
        Comment comment = commentRepository.findById(commentsId).orElseThrow(
                () -> new RuntimeException("Comment not found")
        );

        return new CommentResponseDto(comment);
    }

    /** 모든 코멘트를 조회하는 함수
     *
     * @return 모든 코멘트 정보
     */
    public List<CommentResponseDto> getAllComment() {
        return commentRepository
                .findAll()
                .stream()
                .map(CommentResponseDto::new)
                .toList();
    }

    /** commentsId에 해당하는 코멘트를 수정하는 함수
     *
     * @param commentsId 정보를 갱신할 코멘트 Id
     * @param commentBaseRequestDto 갱신할 정보가 담긴 객체
     * @return 갱신된 코멘트 정보가 담긴 객체
     */
    public CommentResponseDto updateComment(Integer commentsId, CommentBaseRequestDto commentBaseRequestDto) {
        Comment comment = commentRepository.findById(commentsId).orElseThrow(
                () -> new RuntimeException("Comment not found")
        );

        comment.update(commentBaseRequestDto.getCommentData());
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }

    /** commentsId에 해당하는 코멘트를 삭제하는 함수
     *
     * @param commentsId 삭제할 코멘트 Id
     * @return 삭제한 코멘트 Id
     */
    public Integer deleteComment(Integer commentsId) {
        commentRepository.deleteById(commentsId);
        return commentsId;
    }
}
