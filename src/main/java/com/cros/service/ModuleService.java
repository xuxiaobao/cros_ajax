package com.cros.service;

import com.cros.dao.mapper.ModuleMapper;
import com.cros.pojo.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuxiaobao on 2017/7/4.
 */
@Service
public class ModuleService {
    @Autowired
    public ModuleMapper moduleMapper;

    public Module getModule(int id) {
        try {
            return moduleMapper.getModule(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Module> getsModule() {
        try {
            return moduleMapper.getsModule();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
