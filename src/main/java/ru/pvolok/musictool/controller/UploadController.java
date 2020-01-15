package ru.pvolok.musictool.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.pvolok.musictool.helper.cue.CueObject;
import ru.pvolok.musictool.utils.CueUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class UploadController {

    @Value("${java.io.tmpdir}")
    private String tempDir;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] file) throws IOException {
        File cueFile = Paths.get(this.tempDir, file[0].getOriginalFilename()).toFile();
        file[0].transferTo(cueFile);
        CueObject cueObject = CueUtils.readFromFile(cueFile);
        return "Вы удачно загрузили файлы";
    }
}
