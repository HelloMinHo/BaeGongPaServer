package com.example.BaeGongPaServer.Auth;

import com.example.BaeGongPaServer.Component.Exception.GlobalExceptionHandler;
import com.example.BaeGongPaServer.Component.Exception.jwtTokenNotAvailable;
import com.example.BaeGongPaServer.DTO.AuthDTO;
import com.example.BaeGongPaServer.Service.CustomUserDetailService;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthProvider {

    private String secretKey = "BaeGongPaIsSecretKey";

    private long AccessTokenValidTime = 1000L * 60 * 60;
    private long RefreshTokenValidTime = 1000L * 60 * 60 * 24;

    private final CustomUserDetailService customUserDetailService;

    public String getUserInfo(String token) {
        return (String) validateJwtToken(token).get("memId");

    }

    // 토큰 인증 성공시 SecurityContextHolder 에 저장할 Authentication 객체 생성
    public Authentication getAuthentication(String authToken) {

        UserDetails userDetails = customUserDetailService.loadUserByUsername(this.getUserInfo(authToken));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String createAccessToken(AuthDTO authDTO) {
        Map<String, Object> headers = new HashMap<>();
        Map<String, Object> payloads = new HashMap<>();
        // Header 정보
        headers.put("type", "JWT");
        headers.put("alg", "HS256");
        // Payload 정보
        payloads.put("memId", authDTO.getMemId());
        Date date = new Date();
        System.out.println("AccessToken : \n DATE : " + date + "\n ExpirationDate : " + (date.getTime() + AccessTokenValidTime));

        String jwt = Jwts.builder().setHeader(headers).setClaims(payloads).setSubject("access").setIssuedAt(date).setExpiration(new Date(date.getTime() + AccessTokenValidTime)).signWith(SignatureAlgorithm.HS256, secretKey).compact();

        return jwt;
    }

    public String createRefreshToken(AuthDTO authDTO) {
        Map<String, Object> headers = new HashMap<>();
        Map<String, Object> payloads = new HashMap<>();
        // Header 정보
        headers.put("type", "JWT");
        headers.put("alg", "HS256");
        // Payload 정보
        payloads.put("memId", authDTO.getMemId());
        Date date = new Date();
        System.out.println("RefreshToken : \n DATE : " + date + "\n ExpirationDate : " + (date.getTime() + RefreshTokenValidTime));

        String jwt = Jwts.builder().setHeader(headers).setClaims(payloads).setSubject("refresh").setIssuedAt(date).setExpiration(new Date(date.getTime() + RefreshTokenValidTime)).signWith(SignatureAlgorithm.HS256, secretKey).compact();

        return jwt;
    }

    public String reCreateAccessToken(String refreshToken) {
        Claims claims = validateJwtToken(refreshToken);
        AuthDTO authDTO = new AuthDTO(claims.get("memId").toString(), "");
        return createAccessToken(authDTO);
    }

    public boolean validateJwtTokenExceptionExpire(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody();
            return false;
        } catch (ExpiredJwtException e) {
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public Claims validateJwtToken(String authToken) {

        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody();
            return claims;
        } catch (ExpiredJwtException e) {
            throw new jwtTokenNotAvailable("인증 Token 사용 기한이 경과되었습니다.",-1);
        } catch (UnsupportedJwtException e) {
            throw new jwtTokenNotAvailable("지원되지 않는 Token 형식 입니다.",-2);
        } catch (MalformedJwtException e) {
            throw new jwtTokenNotAvailable("인증 Token 이 올바르게 구성되지 않았습니다.",-3);
        } catch (SignatureException e) {
            throw new jwtTokenNotAvailable("인증 Token signature 가 올바르지 않습니다.",-4);
        } catch (IllegalArgumentException e) {
            throw new jwtTokenNotAvailable("인증 Token 을 다시 한 번 확인해 주세요.",-5);
        }
    }


}
