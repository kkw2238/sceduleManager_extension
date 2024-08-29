package com.sparta.schedulemanager_extension.entity;

import com.sparta.schedulemanager_extension.dto.user.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String email;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.REMOVE)

    private List<Manager> managers;

    @OneToMany(mappedBy = "id")
    private List<Comment> comments;

    public User(UserRequestDto userRequestDto) {
        userName = userRequestDto.getUserName();
        email = userRequestDto.getEmail();
    }
}
