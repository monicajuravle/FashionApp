package com.example.fashionapp.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String saveFile(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();  // Poți crea un nume unic pentru fișier
        Path path = Paths.get(uploadDir + File.separator + fileName);

        // Salvează fișierul pe server
        Files.copy(file.getInputStream(), path);

        return fileName;  // Returnează numele fișierului pentru a-l salva în baza de date
    }
}
