package com.example.BaeGongPaServer.Service;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DAO.AuthUserDAO;
import com.example.BaeGongPaServer.DAO.MemPhotoDAO;
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


    public MemPhoto insertMemPhoto(MemPhotoDAO memPhotoDAO) {
        MemPhoto memPhoto = new MemPhoto();
        memPhoto.setPhotoSize(memPhotoDAO.getPhotoSize());
        memPhoto.setPhotoPath(memPhotoDAO.getPhotoPath());
        memPhoto.setPhotoType(memPhotoDAO.getPhotoType());
        memPhoto.setPhotoFile(memPhotoDAO.getPhotoFile());
        memPhoto.setInsDate(LocalDateTime.now());
        return memPhotoRepository.save(memPhoto);
    }

    @Transactional
    public ApiResponse savePhotofile(MultipartFile file) throws IOException {
        ApiResponse apiResponse = new ApiResponse();
        UUID uuid = UUID.randomUUID();
        if (file == null) {
            apiResponse.setCode(400);
            apiResponse.setResultValue("RESULT_CODE", -1);
            apiResponse.setMessage("첨부파일이 존재하지 않습니다.");

        } else {
            String fileType = file.getContentType().substring(file.getContentType().indexOf("/") + 1);
            if (!"png|jpg|jpeg|".contains(fileType)) {
                apiResponse.setCode(400);
                apiResponse.setResultValue("RESULT_CODE", -2);
                apiResponse.setMessage("이미지 파일이 지원하지 않는 형식입니다.");
            } else {
                //String fileOriginPath = "/workspace/assets";
                String fileOriginPath = "D:\\myproject\\assets";

                String filePath = "/img/";
                String fileName = uuid + "." + fileType;
                String fileSize = file.getSize() + "";

                MemPhotoDAO memPhotoDAO = new MemPhotoDAO();
                memPhotoDAO.setPhotoFile(fileName);
                memPhotoDAO.setPhotoPath(filePath);
                memPhotoDAO.setPhotoSize(fileSize);
                memPhotoDAO.setPhotoType("a");

                MemPhoto memPhoto = insertMemPhoto(memPhotoDAO);
                if (insertMemPhoto(memPhotoDAO) == null) {
                    apiResponse.setCode(400);
                    apiResponse.setResultValue("RESULT_CODE", -1);
                    apiResponse.setMessage("이미지 저장에 실패했습니다.");
                } else {
                    file.transferTo(new File(fileOriginPath + filePath + fileName));
                    apiResponse.setCode(200);
                    apiResponse.setMessage("이미지가 저장 되었습니다.");
                    apiResponse.setResultValue("filePath", filePath);
                    apiResponse.setResultValue("fileName", fileName);
                    apiResponse.setResultValue("photoNo", memPhoto.getPhotoNo());
                }
            }
        }
        return apiResponse;
    }

}
