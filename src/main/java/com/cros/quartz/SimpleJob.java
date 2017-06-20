package com.cros.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/4.
 */
public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {
        System.out.println(ctx.getTrigger().getName()+" triggered.time is:" + (new Date()));
    }
}
