package com.cros.service;

import com.cros.dao.mapper.MessageMapper;
import com.cros.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuxiaobao on 2017/7/7.
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getsMessage() {
        try {
            List<Message> list = messageMapper.getsMessage();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
