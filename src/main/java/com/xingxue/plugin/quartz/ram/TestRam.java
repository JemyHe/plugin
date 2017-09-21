package com.xingxue.plugin.quartz.ram;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/20.
 * 要测试以下代码，
 * 请先删除quartz.properties文件，或者重命名！否则会测试不成功！
 * 具体介绍 见classpath:quartz/document/readme.txt 文件
 */
public class TestRam {

    private static Logger logger = LoggerFactory.getLogger(TestRam.class);

    public static void main(String[] args) {

        try {
            //1.创建Scheduler的工厂
            SchedulerFactory sf = new StdSchedulerFactory();
            //2.从工厂中获取调度器实例
            Scheduler scheduler = sf.getScheduler();
            //3.创建JobDetail
            JobDetail jb = JobBuilder.newJob(RamJob.class)
                    .withDescription("this is a ram job") //job的描述
                    .withIdentity("ramJob", "ramGroup") //job 的name和group
                    .build();

            //任务运行的时间，SimpleSchedle类型触发器有效
            long time=  System.currentTimeMillis() + 3*1000L; //3秒后启动任务
            Date statTime = new Date(time);
            //4.创建Trigger
            //使用SimpleScheduleBuilder或者CronScheduleBuilder
            Trigger t = TriggerBuilder.newTrigger()
                    .withDescription("")
                    .withIdentity("ramTrigger", "ramTriggerGroup")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                    .startAt(statTime)  //默认当前时间启动
                    //.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
                    .build();
            //5.注册任务和定时器
            scheduler.scheduleJob(jb, t);
            //6.启动 调度器
            scheduler.start();
            logger.info("启动时间 ： " + new Date());

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
