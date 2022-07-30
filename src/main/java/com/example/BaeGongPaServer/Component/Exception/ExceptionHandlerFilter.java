package com.example.BaeGongPaServer.Component.Exception;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (jwtTokenNotAvailable ex) {
            log.error("GLOBAL_EXCEPTION : " + ex.getMessage());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setCode(401);
            apiResponse.setResultValue("RESULT_CODE", ex.getRstNo());
            apiResponse.setMessage(ex.getMessage());
            objectMapper.writeValue(response.getWriter(), apiResponse);
        } finally {

        }
    }
}
