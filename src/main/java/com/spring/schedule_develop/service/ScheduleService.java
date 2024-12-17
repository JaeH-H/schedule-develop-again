package com.spring.schedule_develop.service;

import com.spring.schedule_develop.dto.ScheduleRequestDto;
import com.spring.schedule_develop.dto.ScheduleResponseDto;
import com.spring.schedule_develop.entity.Schedule;
import com.spring.schedule_develop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto createSchedule(String name, String title, String contents) {

        Schedule schedule = new Schedule(name, title, contents);
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getName(), savedSchedule.getTitle(), savedSchedule.getContents(), savedSchedule.getCreateAt(), savedSchedule.getModifiedAt());
    }


    public List<ScheduleResponseDto> findAllSchedules() {

        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::toDto).toList();
    }


    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        return ScheduleResponseDto.toDto(schedule);
    }


    public ScheduleResponseDto updateById(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (scheduleRequestDto.getTitle() == null || scheduleRequestDto.getContents() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

       schedule.updateById(scheduleRequestDto);

        return ScheduleResponseDto.toDto(scheduleRepository.save(schedule));
    }


    public ScheduleResponseDto deleteById(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        scheduleRepository.delete(schedule);
        return ScheduleResponseDto.toDto(schedule);
    }
}
