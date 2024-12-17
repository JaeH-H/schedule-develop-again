package com.spring.schedule_develop.dto;

import com.spring.schedule_develop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private Long id;

    private String name;

    private String title;

    private String contents;

    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, String name, String title, String contents, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getName(), schedule.getTitle(), schedule.getContents(), schedule.getCreateAt(), schedule.getModifiedAt());
    }
}
