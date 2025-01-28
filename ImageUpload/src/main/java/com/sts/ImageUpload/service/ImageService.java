package com.sts.ImageUpload.service;

import com.sts.ImageUpload.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService
{
    public String uploadImage(MultipartFile imageFile) throws IOException;
    public ImageDTO downloadImage(String imageName);
}
