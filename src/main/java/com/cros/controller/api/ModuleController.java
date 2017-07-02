package com.cros.controller.api;

import com.cros.common.Result;
import com.cros.controller.BaseController;
import com.cros.dao.mapper.ModuleMapper;
import com.cros.pojo.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xuxiaobao on 2017/7/1.
 */
@RestController
@RequestMapping(value = "/module")
public class ModuleController extends BaseController{

    @Autowired
    private ModuleMapper moduleMapper;

    @RequestMapping(value = "/add")
    public Object addModule(@RequestBody Module module) {
        Result result = new Result();
        if (module != null) {
            module.setParentId(0);
            module.setUid(0);
            module.setCreateTime(new Date());

            int i = moduleMapper.addModule(module);
            if (i <= 0) {
                result.set(1, "fail");
            } else {
                result.set(0, "成功");
            }
        } else {
            result.set(1, "fail");
        }
        return result;
    }
}
