package com.xingxue.plugin.quartz.ram;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/20.
 */
public class RamJob implements Job {

    private static Logger logger = LoggerFactory.getLogger(RamJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Say hello to Quartz" + new Date());
    }
}
