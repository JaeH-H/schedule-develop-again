package com.spring.schedule_develop.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;
import jakarta.servlet.FilterChain;


import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {


    private static final String[] WHITE_LIST = {"/", "/users/signup", "/users/login", "/users/logout"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        log.info("로그인 필터 로직 실행");

        if(!isWhiteList(requestURI)) {

            HttpSession session = httpServletRequest.getSession(false);

            if(session == null || session.getAttribute("sessionKey") == null ){
                throw new RuntimeException("로그인 해주세요.");
            }

            log.info("로그인에 성공했습니다.");

        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }

}
