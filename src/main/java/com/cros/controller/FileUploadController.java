package com.cros.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/21.
 */
@RestController
public class FileUploadController {

    private String path_prifx = "/Users/xuxiaobao/pdf_file/";
    private String path_url = "http://localhost:8090/file/";

    @RequestMapping(value = "/upload")
    public Object upload(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID()+suffix;
        String path = path_prifx+filename;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("code", 0);
        map.put("url", path_url+filename);
        map.put("filename", filename);
        return map;
    }
}
