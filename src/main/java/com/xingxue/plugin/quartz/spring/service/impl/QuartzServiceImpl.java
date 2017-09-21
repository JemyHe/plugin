package com.xingxue.plugin.quartz.spring.service.impl;

import com.xingxue.plugin.quartz.spring.entity.JobEntity;
import com.xingxue.plugin.quartz.spring.service.QuartzService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class QuartzServiceImpl implements QuartzService {

    private static final Logger log = LoggerFactory.getLogger(QuartzServiceImpl.class);

    @Autowired
    private Scheduler quartzScheduler;

    @Override
    public void addJob(JobEntity jobEntity) {
        try {
            // 创建一项作业
            Class cls = Class.forName(jobEntity.getJobClass());
            JobDetail job = JobBuilder.newJob(cls)
                    .withIdentity(jobEntity.getJobName(), jobEntity.getJobGroup()).build();
            // 创建一个Cron触发器
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobEntity.getTriggerName(), jobEntity.getTriggerGroupName())
                    .withSchedule(CronScheduleBuilder.cronSchedule(jobEntity.getCronExpr()))
                    .build();
            // 告诉调度器使用该触发器来安排作业
            quartzScheduler.scheduleJob(job, trigger);
            //启动
            if(!quartzScheduler.isStarted()){
                startSchedule();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改定时器任务信息
     */
    @Override
    public boolean modifyJobTime(JobEntity old,JobEntity now) {
        try {
            //取出对应的触发器key
            TriggerKey triggerKey = TriggerKey.triggerKey(old.getTriggerName(), old.getTriggerGroupName());
            //取出对应的Cron触发器，判断是否存在
            CronTrigger trigger = (CronTrigger) quartzScheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return false;
            }
            //取出对应的job作业key
            JobKey jobKey = JobKey.jobKey(old.getJobName(), old.getJobGroup());
            //取出对应的job作业
            JobDetail job = quartzScheduler.getJobDetail(jobKey);
            // 停止触发器
            quartzScheduler.pauseTrigger(triggerKey);
            // 移除触发器
            quartzScheduler.unscheduleJob(triggerKey);
            // 删除任务
            quartzScheduler.deleteJob(jobKey);
            //保存新的作业
            Class jobClass = job.getJobClass();
            now.setJobClass(jobClass.getName());
            addJob(now);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void modifyJobTime(String triggerName, String triggerGroupName,
                              String time) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) quartzScheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                CronTrigger newTrigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule(time))
                        .build();
                quartzScheduler.rescheduleJob(triggerKey, newTrigger);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeJob(String jobName, String jobGroupName,
                          String triggerName, String triggerGroupName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            // 停止触发器
            quartzScheduler.pauseTrigger(triggerKey);
            // 移除触发器
            quartzScheduler.unscheduleJob(triggerKey);
            // 删除任务
            JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
            quartzScheduler.deleteJob(jobKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void startSchedule() {
        try {
            quartzScheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void shutdownSchedule() {
        try {
            if (!quartzScheduler.isShutdown()) {
                quartzScheduler.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pauseJob(String jobName, String jobGroupName) {
        try {
            quartzScheduler.pauseJob( JobKey.jobKey(jobName, jobGroupName));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void resumeJob(String jobName, String jobGroupName) {
        try {
            quartzScheduler.resumeJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startNowJob(String jobName, String jobGroup){

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            quartzScheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
