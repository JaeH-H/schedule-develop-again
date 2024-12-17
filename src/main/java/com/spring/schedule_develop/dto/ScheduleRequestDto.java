package com.spring.schedule_develop.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String name;

    private String title;

    private String contents;

    public ScheduleRequestDto(String name, String title, String contents) {
        this.name = name;
        this.title = title;
        this.contents = contents;
    }
}
