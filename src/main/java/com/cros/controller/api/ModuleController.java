package com.cros.controller.api;

import com.cros.common.Result;
import com.cros.common.ResultCode;
import com.cros.controller.BaseController;
import com.cros.dao.mapper.ModuleMapper;
import com.cros.pojo.Module;
import com.cros.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by xuxiaobao on 2017/7/1.
 */
@RestController
@RequestMapping(value = "/module")
public class ModuleController extends BaseController{

    @Autowired
    private ModuleMapper moduleMapper;

    @Resource
    private ModuleService moduleService;

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

    @RequestMapping(value = "/edit")
    public Object editModule(@RequestParam(name = "id", required = true) int id,
                             @RequestParam(name = "title", required = true) String title,
                             @RequestParam(name = "detail", required = true) String detail) {
        Module module = new Module();
        module.setId(id);
        module.setTitle(title);
        module.setDetail(detail);

        int i = moduleService.editModule(module);

        Result result = new Result();
        if (i <= 0) {
            return result.set(ResultCode.FALIUE, "更新失败");
        }
        return result.set(ResultCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/col")
    public Object getModule(@RequestParam(name = "id", required = true) int id) {
        Result result = new Result();
        Module module = moduleService.getModule(id);
        if (module == null) {
            return result.set(ResultCode.FALIUE, "不存在");
        }
        return result.set(ResultCode.SUCCESS,module);
    }
}
