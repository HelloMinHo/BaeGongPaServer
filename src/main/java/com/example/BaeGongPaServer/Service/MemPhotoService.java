package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.DTO.MemPhotoDto;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.MemPhoto;
import com.example.BaeGongPaServer.Repository.MemPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemPhotoService {


    private final MemPhotoRepository memPhotoRepository;

    public ApiResponse InsMemPhoto(MemPhotoDto memPhotoDto) {
        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MemPhoto memPhoto = new MemPhoto();
        memPhoto.setMemNo(authUserDAO.getMemNo());
        memPhoto.setPhotoPath(memPhotoDto.getPhotoPath());
        memPhoto.setPhotoType(memPhotoDto.getPhotoType());
        memPhoto.setPhotoFile(memPhotoDto.getPhotoFile());
        memPhoto.setPhotoSize(memPhotoDto.getPhotoSize());
        memPhoto.setInsDate(LocalDateTime.now());
        MemPhoto rst = memPhotoRepository.save(memPhoto);

        ApiResponse apiResponse = new ApiResponse();
        if (rst == null) {
            apiResponse.setCode(401);
            apiResponse.setMessage("사진등록 실패");
            apiResponse.setResultValue("data", "");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("사진등록 성공");
            apiResponse.setResultValue("data", rst.getPhotoNo() + " / " + rst.getPhotoPath() + rst.getPhotoFile());

        }

        return apiResponse;

    }

}
