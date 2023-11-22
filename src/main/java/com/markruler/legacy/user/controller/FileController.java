package com.markruler.legacy.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @GetMapping("/files")
    public String goFiles() {
        return "files";
    }

    @PostMapping(path = "/files", consumes = {"multipart/form-data"})
    public String saveFiles(
            @RequestPart(name = "upload-file") MultipartFile file
    ) {
        log.info("multipartFile: {}", file.getOriginalFilename());
        log.info("multipartFile: {}", file.getSize());
        return "files";
    }

}
