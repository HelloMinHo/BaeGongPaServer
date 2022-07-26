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
        String accessToken = request.getHeader("Authentication");
        String refreshToken = request.getHeader("RefreshAuthentication");
        if (refreshToken != null && !accessToken.isEmpty()) {
        } else {
            // 토큰비어있으면 로그인 시도로 구분
            if (accessToken != null && !accessToken.isEmpty()) {
                Authentication authentication = authProvider.getAuthentication(accessToken); // 인증객체 생성
                SecurityContextHolder.getContext().setAuthentication(authentication);   //SecurityContextHolder 인증
            }
        }
        filterChain.doFilter(request, response);
    }
}
