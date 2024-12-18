package com.spring.schedule_develop.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequestDto {

    @Column(nullable = false)
    private final String email;

    @Column(nullable = false)
    private final String password;
}
