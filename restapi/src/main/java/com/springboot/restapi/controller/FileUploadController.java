package com.springboot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.restapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());
        // System.out.println(file.getSize());

        try {

            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("This file type is not supported");
            }

            if (fileUploadHelper.isFileUpload(file)) {
                return ResponseEntity.ok("File uploaded successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong uploading the file");
    }
}
