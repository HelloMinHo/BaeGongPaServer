package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.DTO.MemPhotoDTO;
import com.example.BaeGongPaServer.Domain.MemInfo;
import com.example.BaeGongPaServer.Domain.MemPhoto;
import com.example.BaeGongPaServer.Repository.MemInfoRepository;
import com.example.BaeGongPaServer.Repository.MemPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemPhotoService {


    private final MemPhotoRepository memPhotoRepository;
    private final MemInfoRepository memInfoRepository;

    @Transactional
    public ApiResponse savePhotofile(MultipartFile file) throws IOException {
        ApiResponse apiResponse = new ApiResponse();

        UUID uuid = UUID.randomUUID();
        String fileType = file.getContentType().substring(file.getContentType().indexOf("/") + 1);
        if ("png|jpg|jpeg|".contains(fileType)) {

            String filePath = "img/";
            String fileName = uuid + "." + fileType;
            String fileSize = file.getSize() + "";

            file.transferTo(new File(filePath + fileName));
            apiResponse.setCode(200);
            apiResponse.setMessage("이미지가 저장 되었습니다.");
            apiResponse.setResultValue("filePath", filePath);
            apiResponse.setResultValue("fileName", fileName);
        } else {
            apiResponse.setCode(400);
            apiResponse.setMessage("이미지 파일이 지원하지 않는 형식입니다.");
        }
        return apiResponse;
    }


    @Transactional
    public ApiResponse insertMemPhoto(MemPhotoDTO memPhotoDTO) {
        ApiResponse apiResponse = new ApiResponse();
        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MemPhoto memPhoto = new MemPhoto();

        memPhoto.setMemNo(authUserDAO.getMemNo());
        memPhoto.setPhotoSize(memPhotoDTO.getPhotoSize());
        memPhoto.setPhotoPath(memPhotoDTO.getPhotoPath());
        memPhoto.setPhotoType(memPhoto.getPhotoType());
        memPhoto.setInsDate(LocalDateTime.now());
        MemPhoto rst = memPhotoRepository.save(memPhoto);
        if (rst == null) {
            apiResponse.setCode(400);
            apiResponse.setMessage("이미지를 저장 할 수 없습니다.");
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("이미지가 저장 되었습니다.");
            apiResponse.setResultValue("fileName", rst.getPhotoPath() + rst.getPhotoFile());
        }

        return apiResponse;
    }


}
