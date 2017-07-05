package com.cros.dao.mapper;

import com.cros.pojo.Module;

import java.util.List;

/**
 * Created by xuxiaobao on 2017/7/1.
 */
public interface ModuleMapper {
    int addModule(Module module);

    Module getModule(int id);

    List<Module> getsModule();

    int editModule(Module module);
}
