package com.sparta.schedulemanager_extension.repository;

import com.sparta.schedulemanager_extension.entity.Manager;
import com.sparta.schedulemanager_extension.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    List<Manager> findAllByscheduleId(Schedule scheduleId);

}
