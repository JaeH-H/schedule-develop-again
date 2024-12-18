package com.spring.schedule_develop.controller;

import com.spring.schedule_develop.common.Const;
import com.spring.schedule_develop.dto.LoginRequestDto;
import com.spring.schedule_develop.dto.LoginResponseDto;
import com.spring.schedule_develop.dto.UserResponseDto;
import com.spring.schedule_develop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class SessionUserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest){

        LoginResponseDto responseDto = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Long userId = responseDto.getUserId();

        if(userId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        HttpSession session = httpServletRequest.getSession();

        UserResponseDto loginUser = userService.findById(userId);

        session.setAttribute(Const.LOGIN_USER, loginUser);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
