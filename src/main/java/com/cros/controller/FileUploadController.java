package com.cros.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/21.
 */
@RestController
public class FileUploadController {

    @RequestMapping(value = "/upload")
    public Object upload(MultipartFile file) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("pdfFile", "/user/abc.jpg");
        return map;
    }
}
