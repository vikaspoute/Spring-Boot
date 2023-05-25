package com.springboot.restapi.helper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "C:\\Users\\vikas\\OneDrive\\Desktop\\Spring-Boot\\restapi\\src\\main\\resources\\static\\images";

    public boolean isFileUpload(MultipartFile file) {
        boolean flag = false;

        try {
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + "\\" + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
