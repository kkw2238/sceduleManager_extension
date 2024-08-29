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

    @Column(name = "schedule_title", nullable = false, length = 20)
    private String scheduleTitle;

    @Column(name = "schedule_data", nullable = false, length = 100)
    private String scheduleData;

    @Column(name = "manager_name", nullable = false, length = 20)
    private String managerName;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    public Schedule(String scheduleTitle, String scheduleData, String managerName) {
        this.scheduleTitle = scheduleTitle;
        this.scheduleData = scheduleData;
        this.managerName = managerName;
    }

    public void updateSchedule(String scheduleTitle, String scheduleData) {
        this.scheduleTitle = scheduleTitle;
        this.scheduleData = scheduleData;
    }
}
