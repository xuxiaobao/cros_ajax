package com.cros.service;

import com.cros.dao.mapper.ModuleMenuMapper;
import com.cros.pojo.ModuleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuxiaobao on 2017/7/4.
 */
@Service
public class ModuleMenuService {

    @Autowired
    private ModuleMenuMapper moduleMenuMapper;

    public List<ModuleMenu> getsMenu() {
        try {
            return moduleMenuMapper.getsMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
