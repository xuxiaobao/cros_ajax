package com.cros.controller.api;

import com.cros.biz.LoginBiz;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 许小宝 on 2017/7/4.
 */
@RestController
public class LoginController {

    @Resource
    private LoginBiz loginBiz;

    @RequestMapping(value = "/api/login")
    public Object login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password) {

        return loginBiz.login(username, password);
    }
}
