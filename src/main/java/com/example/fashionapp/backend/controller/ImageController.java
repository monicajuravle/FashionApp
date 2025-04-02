package com.example.fashionapp.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/imagine")
public class ImageController {

    private static final String UPLOAD_DIR = "/uploads/";  // Directorul unde vor fi salvate imaginile

    @PostMapping("/incarca")
    public ResponseEntity<String> incarcaImagine(@RequestParam("imagine") MultipartFile imagine) throws IOException {
        // Obține numele fișierului
        String fileName = System.currentTimeMillis() + "_" + imagine.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);

        // Salvează fișierul pe disc
        Files.copy(imagine.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        // Returnează calea URL a fișierului încărcat
        String fileUrl = "/uploads/" + fileName;  // Poți modifica asta în funcție de configurarea ta
        return ResponseEntity.ok(fileUrl);
    }
}
