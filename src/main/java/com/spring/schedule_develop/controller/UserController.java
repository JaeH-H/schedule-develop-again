package com.spring.schedule_develop.controller;

import com.spring.schedule_develop.dto.LoginRequestDto;
import com.spring.schedule_develop.dto.PasswordRequestDto;
import com.spring.schedule_develop.dto.UserRequestDto;
import com.spring.schedule_develop.dto.UserResponseDto;
import com.spring.schedule_develop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> createUser (@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto.getUserName(), userRequestDto.getEmail(), userRequestDto.getPassword());
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers(){
        List<UserResponseDto> userResponseDto = userService.findAllUsers();

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }


    @PatchMapping("/{userId}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long userId, @RequestBody PasswordRequestDto passwordRequestDto) {
      userService.updatePassword(userId, passwordRequestDto.getOldPassword(), passwordRequestDto.getNewPassword());

      return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable Long userId, @RequestParam String password) {
        UserResponseDto userResponseDto = userService.deleteUser(userId, password);

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

}
