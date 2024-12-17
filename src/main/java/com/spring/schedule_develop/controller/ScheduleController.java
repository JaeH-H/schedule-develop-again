package com.spring.schedule_develop.controller;

import com.spring.schedule_develop.dto.ScheduleRequestDto;
import com.spring.schedule_develop.dto.ScheduleResponseDto;
import com.spring.schedule_develop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(scheduleRequestDto.getName(),scheduleRequestDto.getTitle(), scheduleRequestDto.getContents());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules() {
        List<ScheduleResponseDto> scheduleResponseDto = scheduleService.findAllSchedules();
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {

       ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.updateById(id,scheduleRequestDto);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
