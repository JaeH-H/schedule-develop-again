package com.spring.schedule_develop.dto;

import lombok.Getter;


@Getter

public class LoginResponseDto {

    private final Long userId;

    public LoginResponseDto(Long userId) {
        this.userId = userId;
    }
}
