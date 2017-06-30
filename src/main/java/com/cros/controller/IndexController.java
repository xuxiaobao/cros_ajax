package com.cros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 许小宝 on 2017/6/30.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
