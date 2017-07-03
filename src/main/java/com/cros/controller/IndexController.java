package com.cros.controller;

import com.cros.dao.mapper.ModuleMapper;
import com.cros.pojo.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 许小宝 on 2017/6/30.
 */
@Controller
public class IndexController {

    @Autowired
    private ModuleMapper moduleMapper;

    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap) {

        Module module = moduleMapper.getModule(6);

        modelMap.put("module", module);
        return "front/index";
    }
}
