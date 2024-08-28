package com.sparta.schedulemanager_extension.entity;

import com.sparta.schedulemanager_extension.dto.comment.CommentCreateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment extends BaseEntity {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @Column(name = "comment_data", nullable = false, length = 20)
    private String commentData;

    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;

    public Comment(CommentCreateRequestDto commentCreateRequestDto, Schedule schedule) {
        this.commentData = commentCreateRequestDto.getCommentData();
        this.userName = commentCreateRequestDto.getUserName();
        this.schedule = schedule;
    }

    /**
     * @param commentData 갱신할 데이터
     */
    public void update(String commentData) {
        this.commentData = commentData;
    }
}
