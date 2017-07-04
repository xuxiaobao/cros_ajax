package com.cros.biz;

import com.cros.common.Result;
import com.cros.common.ResultCode;
import com.cros.pojo.User;
import com.cros.service.UserService;
import com.cros.util.MD5;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by 许小宝 on 2017/7/4.
 */
@Component
public class LoginBiz {

    @Resource
    private UserService userService;

    public Object login(String username, String password) {
        Result result = new Result();
        User user = userService.getUserByName(username);
        if (user!= null) {
            if ((MD5.getMd5Value(password)).equals(user.getPassword())) {

                return result.set(ResultCode.SUCCESS, "登陆成功");
            }
        }

        return result.set(ResultCode.FALIUE, "用户名或密码错误");
    }
}
