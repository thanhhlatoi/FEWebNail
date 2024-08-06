package com.example.API.service;

import com.cloudinary.Cloudinary;
import com.example.API.dto.response.CloudinaryResponse;
import com.example.API.exception.FuncErrorException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;
    private static final Logger LOGGER = Logger.getLogger(CloudinaryService.class.getName());
    @Transactional
    public CloudinaryResponse uploadFile(final MultipartFile file, final String fileName) {
        try {
            final Map result = this.cloudinary.uploader()
                    .upload(file.getBytes(),
                            Map.of("public_id", "ntt/product/" + fileName));
            final String url = (String) result.get("secure_url");
            final String publicId = (String) result.get("public_id");
            return CloudinaryResponse.builder().publicId(publicId).url(url).build();

        } catch (final Exception e) {
            LOGGER.log(Level.SEVERE, "Error uploading file to Cloudinary", e);
            throw new FuncErrorException("Failed to upload file: " + e.getMessage());
        }
    }
}
