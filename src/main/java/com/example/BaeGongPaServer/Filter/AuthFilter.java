package com.example.BaeGongPaServer.Filter;

import com.example.BaeGongPaServer.Auth.AuthProvider;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {


    private final AuthProvider authProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authToken = request.getHeader("Authentication");

        // 토큰비어있으면 로그인 시도로 구분
        if (authToken != null && !authToken.isEmpty()) {
            Authentication authentication = authProvider.getAuthentication(authToken); // 인증객체 생성
            SecurityContextHolder.getContext().setAuthentication(authentication);   //SecurityContextHolder 인증
        }
        filterChain.doFilter(request, response);
    }
}
