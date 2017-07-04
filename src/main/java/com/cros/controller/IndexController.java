package com.cros.controller;

import com.cros.dao.mapper.ModuleMapper;
import com.cros.pojo.Module;
import com.cros.pojo.ModuleMenu;
import com.cros.service.ModuleMenuService;
import com.cros.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 许小宝 on 2017/6/30.
 */
@Controller
public class IndexController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ModuleMenuService moduleMenuService;

    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap) {

        dealMenu(1,modelMap);
        if (modelMap.get("module") == null) {
            return "404";
        }
        return "front/index";
    }

    @RequestMapping(value = "/col")
    public String col(@RequestParam int col, ModelMap modelMap) {
        dealMenu(col,modelMap);
        if (modelMap.get("module") == null) {
            return "404";
        }
        return "front/index";
    }

    public void dealMenu(int id, ModelMap modelMap) {
        Module module = moduleService.getModule(id);
        //页面不存在
        if (module == null) {
            return;
        }
        //设置导航栏选中
        int v = 0;
        if (module.getParentId() != 0) {
            v = module.getParentId();
        } else {
            v = module.getId();
        }
        modelMap.put("v", v);
        //设置模块详情
        modelMap.put("module", module);
        //设置导航栏
        List<ModuleMenu> menusList = moduleMenuService.getsMenu();
        Map<String, String> menus = new HashMap<String, String>();
        for (ModuleMenu item : menusList) {
            menus.put(item.getParentId()+"", item.getChildren());
        }
        modelMap.put("menus", menus);
        //设置所有模块信息
        List<Module> modules = moduleService.getsModule();
        Map<String, String> moduleMap = new HashMap<String, String>();
        if (moduleMap != null) {
            for (Module item : modules) {
                moduleMap.put(item.getId()+"", item.getTitle());
            }
            modelMap.put("moduleMap", moduleMap);
        }
    }
}
