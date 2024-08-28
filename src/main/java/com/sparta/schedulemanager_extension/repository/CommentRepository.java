package com.sparta.schedulemanager_extension.repository;

import com.sparta.schedulemanager_extension.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
