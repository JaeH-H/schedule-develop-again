package com.spring.schedule_develop.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private String userName;

    private String email;

    private String password;


    public UserRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
