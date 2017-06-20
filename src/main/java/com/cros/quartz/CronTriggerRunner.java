package com.cros.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by Administrator on 2017/6/8.
 */
public class CronTriggerRunner {
    public static void main(String[] args) {
        try {
            JobDetail jobDetail = new JobDetail("job1_2", "jGroup1", SimpleJob.class);
            CronTrigger cronTrigger = new CronTrigger("trigger1_2", "tgroup1");
            CronExpression cexp = new CronExpression("0/5 * * * * ?");

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
