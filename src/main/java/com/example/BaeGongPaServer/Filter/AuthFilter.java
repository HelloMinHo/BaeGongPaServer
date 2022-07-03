package com.example.BaeGongPaServer.Filter;

import com.example.BaeGongPaServer.Auth.AuthProvider;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class AuthFilter extends GenericFilterBean {

    private final AuthProvider authProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String authToken = req.getHeader("Authentication");

        try {
<<<<<<< HEAD

            if (!authToken.isEmpty() && authProvider.validateJwtToken(req, authToken)) {    // token 검증
                System.out.println("AuthFilter:Authentication = " + authToken);
                Authentication authentication = authProvider.getAuthentication(authToken); // 인증객체 생성

=======
            if (authToken != null && !authToken.isEmpty() && authProvider.validateJwtToken(req, authToken)) {    // token 검증
                System.out.println("AuthFilter:Authentication = " + authToken);
                Authentication authentication = authProvider.getAuthentication(authToken); // 인증객체 생성
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
                SecurityContextHolder.getContext().setAuthentication(authentication);   //SecurityContextHolder 인증
            }
        } catch (Exception e) {
            System.out.println("AuthFilter:Exception:" + e.getMessage());

        } finally {
            chain.doFilter(request, response);
            System.out.println("AuthFilter:CONTINUE");
<<<<<<< HEAD
//            AuthUserDAO authUserDAO =  (AuthUserDAO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            System.out.println(authUserDAO);

        }


    }

=======
        }
    }
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
}
