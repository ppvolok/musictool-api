package ru.pvolok.musictool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class UploadController {

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] file) {
        for (int i = 0; i < file.length; i++) {
            if (!file[i].isEmpty()) {
                try {
                    byte[] bytes = file[i].getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(i + "-uploaded")));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    return "Вам не удалось загрузить " + i + " => " + e.getMessage();
                }
            }
        }
        return "Вы удачно загрузили файлы";
    }
}
