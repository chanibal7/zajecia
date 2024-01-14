/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-webapp
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 2023-12-17
 *
 *****************************************************/
package com.software.conf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.software.AppConstant.JobTypes;
import com.software.service.schedulers.EmailSendingJob;
import com.software.service.schedulers.SmsReceivingJob;
import com.software.service.schedulers.SmsSendingJob;

@PropertySource("classpath:jobs_conf.properties")
@Configuration
public class JobsConf {

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public JobDetail emailSendingJob() {
        return JobBuilder.newJob(EmailSendingJob.class).withIdentity(new JobKey(JobTypes.JOB, JobTypes.EMAIL)).build();
    }

    @Bean
    public CronTrigger emailSendingTrigger() {
        return TriggerBuilder.newTrigger().withIdentity(new TriggerKey(JobTypes.JOB, JobTypes.EMAIL))
                .withSchedule(CronScheduleBuilder.cronSchedule(env.getProperty("email.sending.cron"))).build();
    }

    @Bean
    public JobDetail smsSendingJob() {
        return JobBuilder.newJob(SmsSendingJob.class).withIdentity(new JobKey(JobTypes.JOB, JobTypes.SMS_SEND)).build();
    }

    @Bean
    public CronTrigger smsSendingTrigger() {
        return TriggerBuilder.newTrigger().withIdentity(new TriggerKey(JobTypes.JOB, JobTypes.SMS_SEND))
                .withSchedule(CronScheduleBuilder.cronSchedule(env.getProperty("sms.sending.cron"))).build();
    }

    @Bean
    public JobDetail smsReceivingJob() {
        return JobBuilder.newJob(SmsReceivingJob.class).withIdentity(new JobKey(JobTypes.JOB, JobTypes.SMS_RECEIVE)).build();
    }

    @Bean
    public CronTrigger smsRecevingTrigger() {
        return TriggerBuilder.newTrigger().withIdentity(new TriggerKey(JobTypes.JOB, JobTypes.SMS_RECEIVE))
                .withSchedule(CronScheduleBuilder.cronSchedule(env.getProperty("sms.receiving.cron"))).build();
    }

    @Bean
    public Scheduler schedulerFactoryBean() throws SchedulerException {
        final Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        if (Boolean.valueOf(env.getProperty("jobs.enabled"))) {
            scheduler.start();
        }
        scheduler.scheduleJobs(prepareJobsAndTriggers(), true);

        final AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        scheduler.setJobFactory(jobFactory);

        return scheduler;
    }

    @SuppressWarnings("serial")
    private Map<JobDetail, Set<? extends Trigger>> prepareJobsAndTriggers() {

        final Map<JobDetail, Set<? extends Trigger>> triggersAndJobs = new HashMap<JobDetail, Set<? extends Trigger>>();

        triggersAndJobs.put(emailSendingJob(), new HashSet<CronTrigger>() {
            {
                add(emailSendingTrigger());
            }
        });
        triggersAndJobs.put(smsSendingJob(), new HashSet<CronTrigger>() {
            {
                add(smsSendingTrigger());
            }
        });
        triggersAndJobs.put(smsReceivingJob(), new HashSet<CronTrigger>() {
            {
                add(smsRecevingTrigger());
            }
        });
        return triggersAndJobs;
    }
}
