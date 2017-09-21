package com.xingxue.plugin.quartz.spring.service;

import com.xingxue.plugin.quartz.spring.entity.JobEntity;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface QuartzService {
    /**
     * addJob(方法描述：添加一个定时任务)
     * @exception
     * @since 1.0.0
     */
    public void addJob(JobEntity jobEntity);

    /**
     * @param old 原job ---包括作业名，作业组名，触发器名，触发器组名
     * @param now 新job ---在以上基础上，需要包含cron表达式
     */
    public boolean modifyJobTime(JobEntity old,JobEntity now);

    /**
     * 修改触发器调度时间
     * @param triggerName  触发器名称
     * @param triggerGroupName  触发器组名称
     * @param cron cron表达式
     */
    public void modifyJobTime(String triggerName,
                              String triggerGroupName, String cron);


    /**
     * 暂停指定的任务
     * @param jobName 任务名称
     * @param jobGroupName 任务组名称
     * @return
     */
    public void pauseJob(String jobName,String jobGroupName);

    /**
     * 恢复指定的任务
     * @param jobName 任务名称
     * @param jobGroupName 任务组名称
     * @return
     */
    public void resumeJob(String jobName,String jobGroupName);

    /**
     * 删除指定组任务
     * @param jobName 作业名称
     * @param jobGroupName 作业组名称
     * @param triggerName 触发器名称
     * @param triggerGroupName 触发器组名称
     */
    public void removeJob(String jobName, String jobGroupName,
                          String triggerName, String triggerGroupName);


    /**
     * 开始所有定时任务。启动调度器
     */
    public void startSchedule();

    /**
     * 关闭调度器
     */
    public void shutdownSchedule();

    /**
     * 立即执行一次作业
     * @param jobName
     * @param jobGroup
     */
    public void startNowJob(String jobName, String jobGroup);
}
