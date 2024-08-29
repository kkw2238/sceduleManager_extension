package com.sparta.schedulemanager_extension.repository;

import com.sparta.schedulemanager_extension.entity.Schedule;
import com.sparta.schedulemanager_extension.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Integer> {
}
