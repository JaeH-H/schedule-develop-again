package com.spring.schedule_develop.entity;

import com.spring.schedule_develop.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;


    public User() {}

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public void updateUser(UserRequestDto userRequestDto) {
        this.userName = userRequestDto.getUserName();
    }


}
