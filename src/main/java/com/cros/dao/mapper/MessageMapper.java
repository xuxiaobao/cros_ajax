package com.cros.dao.mapper;

import com.cros.pojo.Message;

import java.util.List;

/**
 * Created by xuxiaobao on 2017/7/7.
 */
public interface MessageMapper {
    List<Message> getsMessage();

    Message getMessage(int id);

    int addMessage(Message message);

    int updateMessageCheck(int id);
}
