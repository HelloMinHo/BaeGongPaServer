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

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemPhotoService {


    private final MemPhotoRepository memPhotoRepository;
    private final MemInfoRepository memInfoRepository;

    @Transactional
    public ApiResponse savePhotofile(MultipartFile file) {
        ApiResponse apiResponse = new ApiResponse();
        AuthUserDAO authUserDAO = (AuthUserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MemInfo memInfo = memInfoRepository.findByMemId(authUserDAO.getMemId());
        UUID uuid = UUID.randomUUID();
        String fileType = file.getContentType().substring(file.getContentType().indexOf("/") + 1);
        if ("png|jpg|jpeg|".contains(fileType)) {

            String filePath = "img/";
            String fileName = uuid + "." + fileType;
            String fileSize = file.getSize() + "";

            memInfo.setMemPfPhoto(filePath + fileName);
            memInfoRepository.save(memInfo);

            MemPhoto memPhoto = new MemPhoto();
            memPhoto.setMemNo(authUserDAO.getMemNo());
            memPhoto.setPhotoPath(filePath);
            memPhoto.setPhotoType("a");
            memPhoto.setPhotoFile(fileName);
            memPhoto.setPhotoSize(fileSize);
            memPhoto.setInsDate(LocalDateTime.now());
            MemPhoto rst = memPhotoRepository.save(memPhoto);
            if (rst == null) {
                apiResponse.setCode(400);
                apiResponse.setMessage("이미지를 저장 할 수 없습니다.");
            } else {
                apiResponse.setCode(200);
                apiResponse.setMessage("이미지가 저장 되었습니다.");
                apiResponse.setResultValue("filePath", rst.getPhotoPath() + rst.getPhotoFile());
            }
        } else {
            apiResponse.setCode(400);
            apiResponse.setMessage("이미지 파일이 지원하지 않는 형식입니다.");
        }
        return apiResponse;
    }


}
