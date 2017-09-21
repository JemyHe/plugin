package com.xingxue.plugin.quartz.spring.service.impl;

import com.xingxue.plugin.quartz.spring.entity.JobEntity;
import com.xingxue.plugin.quartz.spring.service.QuartzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:quartz/spring/spring-*.xml")
public class QuartzServiceImplTest {

    @Autowired private QuartzService quartzService;

    @Test
    public void addJob() throws Exception {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobName("job1");
        jobEntity.setJobGroup("group1");
        jobEntity.setTriggerName("trigger1");
        jobEntity.setTriggerGroupName("group1");
        jobEntity.setJobClass("com.xingxue.plugin.quartz.spring.job.TaskA");
        jobEntity.setCronExpr("0/2 * * * * ? *");
        quartzService.addJob(jobEntity);
        System.out.println("添加成功");
        Thread.sleep(100000);
    }

    @Test
    public void modifyJobTime() throws Exception {

        JobEntity old = new JobEntity();
        old.setJobName("job5");
        old.setJobGroup("group2");
        old.setTriggerName("trigger2");
        old.setTriggerGroupName("group1");
        JobEntity now = new JobEntity();
        now.setJobName("job99");
        now.setJobGroup("group2");
        now.setTriggerName("trigger2");
        now.setTriggerGroupName("group1");
        now.setCronExpr("0/3 * * * * ?");
        quartzService.modifyJobTime(old,now);

    }

    @Test
    public void modifyJobTime1() throws Exception {
        quartzService.modifyJobTime("trigger2","group1","0/5 * * * * ?");
    }

    @Test
    public void removeJob() throws Exception {

        quartzService.removeJob("job1","group1","trigger1","group1");
    }

    @Test
    public void startSchedule() throws Exception {
        quartzService.startSchedule();
    }

    @Test
    public void shutdownSchedule() throws Exception {
    }

    @Test
    public void pauseJob() throws Exception {
        quartzService.pauseJob("job99","group2");
    }

    @Test
    public void resumeJob() throws Exception {
        quartzService.pauseJob("job99","group2");
    }

    @Test
    public void startNowJob() throws Exception {
        quartzService.startNowJob("job66","group2");
    }

}