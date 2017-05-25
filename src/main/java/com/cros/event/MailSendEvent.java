package com.cros.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Created by Administrator on 2017/5/25.
 */
public class MailSendEvent extends ApplicationContextEvent {

    private String to;
    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {
        return this.to;
    }
}
