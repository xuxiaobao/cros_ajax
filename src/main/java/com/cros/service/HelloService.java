package com.cros.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/19.
 */
@Service
public class HelloService {

    @Scheduled(fixedDelay = 2000)
    public void task() {
        System.out.println("schedule start!");
    }
}
