package com.example.BaeGongPaServer.Auth;

<<<<<<< HEAD
=======
import com.example.BaeGongPaServer.DTO.AuthDTO;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
import com.example.BaeGongPaServer.Service.CustomUserDetailService;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthProvider {

    private String secretKey = "minho";

    private long tokenValidTime = 1000L * 60 * 60;

    private final CustomUserDetailService customUserDetailService;

    public String getUserInfo(String token) {
        return (String) Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("id");
    }

    // 토큰 인증 성공시 SecurityContextHolder 에 저장할 Authentication 객체 생성
    public Authentication getAuthentication(String authToken) {

        UserDetails userDetails = customUserDetailService.loadUserByUsername(this.getUserInfo(authToken));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

<<<<<<< HEAD
    public String createToken(String user) {
=======
    public String createToken(AuthDTO authDTO) {
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
        Map<String, Object> headers = new HashMap<>();
        Map<String, Object> payloads = new HashMap<>();

        // Header 정보
        headers.put("type", "JWT");
        headers.put("alg", "HS256");

        // Payload 정보
<<<<<<< HEAD
        payloads.put("id", user);
        payloads.put("name", "name_" + user);

=======
        payloads.put("memId", authDTO.getMemId());
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144

        Date date = new Date();
        System.out.println("SecretKey : " + secretKey);
        System.out.println("Date : " + date + ",Expiration: " + (date.getTime() + tokenValidTime));

        String jwt = Jwts
                .builder()
                .setHeader(headers)
                .setClaims(payloads)
<<<<<<< HEAD
                .setSubject("subject_name")
=======
                .setSubject("user")
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        System.out.println("Token:" + jwt);

        return jwt;
    }

    public boolean validateJwtToken(ServletRequest request, String authToken) {


        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            request.setAttribute("exception", "MalformedJwtException");
        } catch (ExpiredJwtException e) {
            request.setAttribute("exception", "ExpiredJwtException");
        } catch (UnsupportedJwtException e) {
            request.setAttribute("exception", "UnsupportedJwtException");
        } catch (IllegalArgumentException e) {
            request.setAttribute("exception", "IllegalArgumentException");
        }
        return false;


    }


}
