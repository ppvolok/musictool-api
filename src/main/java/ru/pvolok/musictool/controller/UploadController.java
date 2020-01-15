package ru.pvolok.musictool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class UploadController {

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] file) throws IOException {
        File cueFile = Paths.get(System.getProperty("java.io.tmpdir"), file[0].getOriginalFilename()).toFile();
        file[0].transferTo(cueFile);
        return "Вы удачно загрузили файлы";
    }
}
