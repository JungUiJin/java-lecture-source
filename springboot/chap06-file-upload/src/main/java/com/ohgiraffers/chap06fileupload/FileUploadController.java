package com.ohgiraffers.chap06fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @PostMapping("/single-file")
    public String singleFileUpload(
            @RequestParam String singleFileDescription,
            @RequestParam MultipartFile singleFile,
            Model model
    ) {
        System.out.println("singleFileDescription: " + singleFileDescription);
        System.out.println("singleFile: " + singleFile);

        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";

        File dir = new File(filePath);

        if (!dir.exists()) dir.mkdirs();

        // 파일명이 중복될 수 있으므로 중복 되지 않는 이름으로 변경
        String originFileName = singleFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID() + ext;

        try {
            singleFile.transferTo(new File(filePath+"/"+savedName));
            model.addAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
//            throw new RuntimeException(e);
            model.addAttribute("message", "File upload failed!");
        }
        return "result";
    }

    @PostMapping("/multi-file")
    public String multiFileUpload(
            @RequestParam String multiFilesDescription,
            @RequestParam List<MultipartFile> multiFiles,
            Model model
    ){
        System.out.println("multiFilesDescription: " + multiFilesDescription);
        System.out.println("multiFiles: " + multiFiles);

        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";

        File dir = new File(filePath);

        if (!dir.exists()) dir.mkdirs();

        List<FileDTO> files = new ArrayList<>();

        try {
            for (MultipartFile multiFile : multiFiles) {
                String fileName = multiFile.getOriginalFilename();
                String ext = fileName.substring(fileName.lastIndexOf("."));
                String savedName = UUID.randomUUID() + ext;

                multiFile.transferTo(new File(filePath+"/"+savedName));

                /* 파일에 관한 정보를 dto에 담아 list에 보관 */
                files.add(new FileDTO(fileName,savedName,filePath,multiFilesDescription));

            }
            model.addAttribute("message", "Multi File uploaded successfully!");
        } catch (IOException e) {
            /* 파일 저장이 중간에 실패할 경우 이전에 저장된 파일 삭제 */
//            throw new RuntimeException(e);
            model.addAttribute("message", "Multi File uploaded successfully!");
        }
        return "result";
    }

}

