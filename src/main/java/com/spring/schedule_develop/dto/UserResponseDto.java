package com.spring.schedule_develop.dto;

import com.spring.schedule_develop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private Long userId;

    private String userName;

    private String email;

    private LocalDateTime createAt;


    public UserResponseDto(Long userId, String userName, String email, LocalDateTime createAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.createAt = createAt;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getUserId(), user.getUserName(), user.getEmail(), user.getCreateAt());
    }

}
