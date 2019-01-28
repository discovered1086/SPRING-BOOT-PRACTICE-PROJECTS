package com.kingshuk.springboot.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    @RequestMapping("/upload")
    public String uploadFile(Model theModel,
                             @RequestParam("file") MultipartFile theFile) {
        theModel.addAttribute("fileName", theFile.getOriginalFilename());

        try {
            theFile.transferTo(
                    new File("/Volumes/Work/PROJECTS/SPRING-PROJECTS/BareBonesSpringMVCApp/file-target/"
                            +theFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "review_fileUpload";
    }
}
