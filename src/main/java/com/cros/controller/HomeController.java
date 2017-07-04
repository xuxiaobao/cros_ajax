package com.cros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xuxiaobao on 2017/7/4.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/back/home")
    public String home() {

        return "back/index";
    }
}
