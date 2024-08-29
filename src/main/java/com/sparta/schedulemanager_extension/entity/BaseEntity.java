package com.sparta.schedulemanager_extension.entity;

import com.sparta.schedulemanager_extension.utility.DateUtility;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "create_datetime", updatable = false, nullable = false, length = 20)
    protected String createDateTime;

    @LastModifiedDate
    @Column(name = "edit_datetime", nullable = false, length = 20)
    protected String editDateTime;

    /**
     *  데이터 삽입 전 진행되는 함수
     */
    @PrePersist
    public void prePersist() {
        this.createDateTime = DateUtility.localDateTimeToString(LocalDateTime.now(DateUtility.getTimeZone()));
        this.editDateTime = this.createDateTime;
    }

    /**
     * 데이터 갱신 전 진행되는 함수
     */
    @PreUpdate
    public void preUpdate() {
        this.editDateTime = DateUtility.localDateTimeToString(LocalDateTime.now(DateUtility.getTimeZone()));
    }
}
