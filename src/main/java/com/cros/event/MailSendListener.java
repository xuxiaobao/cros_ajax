package com.cros.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * 配置自定义事件监听器
 * Created by Administrator on 2017/5/25.
 */
@Configuration
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    //对mailsendevent事件进行处理
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mse = event;
        System.out.println("MailSendListenter 向"+mse.getTo()+"发送完一封邮件.");
    }
}
