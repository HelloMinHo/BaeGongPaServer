package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemInfoRepository memInfoRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {

        MemInfo memInfo = memInfoRepository.findByMemId(memId);
        if (memInfo == null) {
            throw new UsernameNotFoundException("memInfo is not found.");
        }

        AuthUserDAO authUserDAO = new AuthUserDAO();
        authUserDAO.setMemNo(memInfo.getMemNo());
        authUserDAO.setMemId(memInfo.getMemId());
        authUserDAO.setMemPwd(passwordEncoder.encode(memInfo.getMemPwd()));
        authUserDAO.setMemNick(memInfo.getMemNick());
        authUserDAO.setRole(memInfo.getMemRoll() + "");

        return authUserDAO;
    }
}
