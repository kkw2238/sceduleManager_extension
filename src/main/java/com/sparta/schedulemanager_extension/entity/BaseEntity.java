package com.sparta.schedulemanager_extension.entity;

import com.sparta.schedulemanager_extension.utility.DateUtility;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "create_datetime", updatable = false, nullable = false, length = 20)
    protected String createDateTime;

    @LastModifiedDate
    @Column(name = "edit_datetime", nullable = false, length = 20)
    protected String editDateTime;

    @PrePersist
    public void prePersist() {
        this.createDateTime = DateUtility.localDateTimeToString(LocalDateTime.now(DateUtility.getTimeZone()));
        this.editDateTime = this.createDateTime;
    }

    @PreUpdate
    public void preUpdate() {
        this.editDateTime = DateUtility.localDateTimeToString(LocalDateTime.now(DateUtility.getTimeZone()));
    }
}
