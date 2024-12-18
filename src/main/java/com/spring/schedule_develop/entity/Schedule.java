package com.spring.schedule_develop.entity;

import com.spring.schedule_develop.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    //연관관계
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Schedule() {}

    public Schedule(String name, String title, String contents) {
        this.name = name;
        this.title = title;
        this.contents = contents;
    }

    public void updateById(ScheduleRequestDto scheduleRequestDto) {
        this.title = scheduleRequestDto.getTitle();
        this.contents = scheduleRequestDto.getContents();
    }
}
