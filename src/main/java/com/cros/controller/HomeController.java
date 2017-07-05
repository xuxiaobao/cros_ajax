package com.cros.controller;

import com.cros.pojo.Module;
import com.cros.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xuxiaobao on 2017/7/4.
 */
@Controller
public class HomeController {
    @Resource
    private ModuleService moduleService;

    @RequestMapping(value = "/back/home")
    public String home(ModelMap modelMap) {
        List<Module> list = moduleService.getsModule();
        //一级模块列表
        modelMap.put("list", list);
        return "back/index";
    }
}
