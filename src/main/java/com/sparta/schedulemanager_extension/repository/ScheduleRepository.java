package com.sparta.schedulemanager_extension.repository;
import com.sparta.schedulemanager_extension.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
