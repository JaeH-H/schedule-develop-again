package com.spring.schedule_develop.controller;

import com.spring.schedule_develop.common.Const;
import com.spring.schedule_develop.dto.LoginRequestDto;
import com.spring.schedule_develop.entity.User;
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
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        User loginUser = userService.login(loginRequestDto);

        HttpSession session = request.getSession();
        session.setAttribute(Const.LOGIN_USER, loginUser);

        return new ResponseEntity<>("로그인 되었습니다.", HttpStatus.OK);

    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest httpServletRequest){

        HttpSession session = httpServletRequest.getSession(false);

        if(session != null){
            session.invalidate();
        }

        return new ResponseEntity<>("로그아웃 되었습니다.", HttpStatus.OK);
    }

}
