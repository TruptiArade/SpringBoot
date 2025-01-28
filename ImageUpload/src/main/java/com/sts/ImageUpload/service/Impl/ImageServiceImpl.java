package com.sts.ImageUpload.service.Impl;

import com.sts.ImageUpload.dto.ImageDTO;
import com.sts.ImageUpload.entity.Image;
import com.sts.ImageUpload.repository.ImageRepository;
import com.sts.ImageUpload.service.ImageService;
import com.sts.ImageUpload.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;

    public String uploadImage(MultipartFile imageFile) throws IOException {
        // Create ImageDTO from MultipartFile
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setName(imageFile.getOriginalFilename());
        imageDTO.setType(imageFile.getContentType());
        imageDTO.setImageData(ImageUtils.compressImage(imageFile.getBytes()));

        // Convert ImageDTO to Image entity using ModelMapper
        Image imageToSave = modelMapper.map(imageDTO, Image.class);

        // Save the Image entity
        imageRepository.save(imageToSave);

        return "File uploaded successfully: " + imageDTO.getName();
    }

    public ImageDTO downloadImage(String imageName) {
        Optional<Image> dbImage = imageRepository.findByName(imageName);

        return dbImage.map(image -> {
            try {
                // Decompress image data and map to DTO
                image.setImageData(ImageUtils.decompressImage(image.getImageData()));
                return modelMapper.map(image, ImageDTO.class);
            } catch (DataFormatException | IOException exception) {
                throw new ContextedRuntimeException("Error downloading an image", exception)
                        .addContextValue("Image ID", image.getId())
                        .addContextValue("Image name", imageName);
            }
        }).orElse(null);
    }
}
