package com.cros.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/4.
 */
public class SimpleTriggerRunner {

    public static void main(String[] args) {
        try {
            JobDetail jobDetail = new JobDetail("job1_1", "jgroup1", SimpleJob.class);
            SimpleTrigger trigger = new SimpleTrigger("trigger1_1", "tgroup1", new Date());
            trigger.setRepeatCount(20);
            trigger.setRepeatInterval(1000);

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (Exception e) {

        }
    }
}
