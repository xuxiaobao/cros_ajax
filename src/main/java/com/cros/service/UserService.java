package com.cros.service;

import com.cros.dao.mapper.UserMapper;
import com.cros.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 许小宝 on 2017/7/4.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserByName(String userName) {
        try {
            User user = userMapper.getUserByName(userName);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
