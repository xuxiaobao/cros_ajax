package com.cros.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/19.
 */
@Service
public class HelloService {
    /**
     * 上次任务执行结束时间到下次任务开始时间，间隔是2000毫秒
     */
    /*@Scheduled(fixedDelay = 2000)
    public void task() {
        System.out.println("schedule start!");
    }*/

    /**
     * 上次任务开始时间到下次任务开始时间，间隔是2000毫秒
     */
    /*@Scheduled(fixedRate = 2000)
    public void task() {
        System.out.println("schedule start");
    }*/


    /**
     字段         允许值                 允许的特殊字符
     秒 	  	     0-59 	  	            , - * /
     分 	  	     0-59 	  	            , - * /
     小时 	  	 0-23 	  	            , - * /
     日期 	  	 1-31 	  	            , - * ? / L W C
     月份 	   	 1-12 或者 JAN-DEC 	  	, - * /
     星期 	  	 1-7 或者 SUN-SAT 	  	, - * ? / L C #
     年（可选） 	 留空, 1970-2099 	  	, - * /
     */

    /**
     * 详细配置方法执行
     * 秒 分 时 日 月 周
     *
     * 下面配置2秒执行一次
     */
    @Scheduled(cron = "0-6/2 * * * * ?")
    public void task() {
        System.out.println("cron schedule start");
    }
}
