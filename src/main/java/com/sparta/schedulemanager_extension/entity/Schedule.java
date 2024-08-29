package com.sparta.schedulemanager_extension.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "schedule")
@EntityListeners(AuditingEntityListener.class)
public class Schedule extends BaseEntity {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "writer")
    private int writer;

    @Column(name = "schedule_title", nullable = false, length = 20)
    private String scheduleTitle;

    @Column(name = "schedule_data", nullable = false, length = 100)
    private String scheduleData;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    // 스케쥴이 사라지면 manager에서 해당 스케쥴을 관리하는 사람의 내용을 모두 제거해야 한다.
    @OneToMany(mappedBy = "scheduleId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Manager> managers;

    public Schedule(String scheduleTitle, String scheduleData, int writer) {
        this.scheduleTitle = scheduleTitle;
        this.scheduleData = scheduleData;
        this.writer = writer;
    }

    public void updateSchedule(String scheduleTitle, String scheduleData) {
        this.scheduleTitle = scheduleTitle;
        this.scheduleData = scheduleData;
    }
}
