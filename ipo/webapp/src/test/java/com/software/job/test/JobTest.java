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
 *  Created: 18-12-2023
 *
 *****************************************************/
package com.software.job.test;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.ReflectionUtils;

import com.software.AppConstant.JobTypes;
import com.sofware.conf.MailConf;
import com.software.conf.JobsConf;
import com.software.conf.SecurityConf;
import com.software.conf.TestDataContext;
import com.software.conf.ViewConf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataContext.class, ViewConf.class, SecurityConf.class, MailConf.class, JobsConf.class})
@WebAppConfiguration
public class JobTest{

    private static final String CRON_EXPRESSION_FIVE_MINUTES = "0 0/5 * * * ?";

    @Autowired
    Scheduler schedulerFactoryBean;

    @Test
    public void jobsShouldBeEnabled() throws SchedulerException{
	Assert.assertFalse(schedulerFactoryBean.isStarted());
    }

    @Test
    public void jobsShouldHaveEmailSendingConfiguration() throws SchedulerException, IllegalAccessException, IllegalArgumentException {
	// given
	final TriggerKey triggerKey = TriggerKey.triggerKey(JobTypes.JOB, JobTypes.EMAIL);
	final JobKey jobKey = JobKey.jobKey(JobTypes.JOB, JobTypes.EMAIL);

	// when
	final List<? extends Trigger> triggersOfJob = schedulerFactoryBean.getTriggersOfJob(jobKey);

	// then
	Assert.assertEquals(1, triggersOfJob.size());
	for (final Trigger trigger : triggersOfJob) {
	    final TriggerState triggerState = schedulerFactoryBean.getTriggerState(trigger.getKey());
	    Assert.assertEquals(TriggerState.NORMAL, triggerState);
	    Assert.assertEquals(triggerKey, trigger.getKey());
	    assertCronExpressionInTrigger(trigger);
	}
    }

    private void assertCronExpressionInTrigger(final Trigger trigger) throws IllegalAccessException, IllegalArgumentException{
	final Field field = ReflectionUtils.findField(trigger.getClass(), "cronEx");
	field.setAccessible(true);
	Assert.assertEquals(CRON_EXPRESSION_FIVE_MINUTES, field.get(trigger).toString());
    }

    @Test
    public void jobsShouldHaveSmsSendingConfiguration() throws SchedulerException, IllegalAccessException, IllegalArgumentException{
	// given
	final TriggerKey triggerKey = TriggerKey.triggerKey(JobTypes.JOB, JobTypes.SMS_SEND);
	final JobKey jobKey = JobKey.jobKey(JobTypes.JOB, JobTypes.SMS_SEND);

	// when
	final List<? extends Trigger> triggersOfJob = schedulerFactoryBean.getTriggersOfJob(jobKey);

	// then
	Assert.assertEquals(1, triggersOfJob.size());
	for (final Trigger trigger : triggersOfJob) {
	    final TriggerState triggerState = schedulerFactoryBean.getTriggerState(trigger.getKey());
	    Assert.assertEquals(TriggerState.NORMAL, triggerState);
	    Assert.assertEquals(triggerKey, trigger.getKey());
	    assertCronExpressionInTrigger(trigger);
	}
    }

    @Test
    public void jobsShouldHaveSmsReceivingConfiguration() throws SchedulerException, IllegalAccessException, IllegalArgumentException{
	// given
	final TriggerKey triggerKey = TriggerKey.triggerKey(JobTypes.JOB, JobTypes.SMS_RECEIVE);
	final JobKey jobKey = JobKey.jobKey(JobTypes.JOB, JobTypes.SMS_RECEIVE);

	// when
	final List<? extends Trigger> triggersOfJob = schedulerFactoryBean.getTriggersOfJob(jobKey);

	// then
	Assert.assertEquals(1, triggersOfJob.size());
	for (final Trigger trigger : triggersOfJob) {
	    final TriggerState triggerState = schedulerFactoryBean.getTriggerState(trigger.getKey());
	    Assert.assertEquals(TriggerState.NORMAL, triggerState);
	    Assert.assertEquals(triggerKey, trigger.getKey());
	    assertCronExpressionInTrigger(trigger);
	}
    }

    @Test
    public void jobsShouldContainsEmailSendingJobs() throws SchedulerException {
	// given
	final TriggerKey triggerKey = TriggerKey.triggerKey(JobTypes.JOB, JobTypes.EMAIL);
	final JobKey jobKey = JobKey.jobKey(JobTypes.JOB, JobTypes.EMAIL);

	// then
	Assert.assertTrue(schedulerFactoryBean.checkExists(triggerKey));
	Assert.assertTrue(schedulerFactoryBean.checkExists(jobKey));
    }

    @Test
    public void jobsShouldContainsSmsSendingJobs() throws SchedulerException  {
	// given
	final TriggerKey triggerKey = TriggerKey.triggerKey(JobTypes.JOB, JobTypes.SMS_SEND);
	final JobKey jobKey = JobKey.jobKey(JobTypes.JOB, JobTypes.SMS_SEND);

	// then
	Assert.assertTrue(schedulerFactoryBean.checkExists(triggerKey));
	Assert.assertTrue(schedulerFactoryBean.checkExists(jobKey));
    }

    @Test
    public void jobsShouldContainsSmsReceivingJobs() throws SchedulerException  {
	// given
	final TriggerKey triggerKey = TriggerKey.triggerKey(JobTypes.JOB, JobTypes.SMS_RECEIVE);
	final JobKey jobKey = JobKey.jobKey(JobTypes.JOB, JobTypes.SMS_RECEIVE);

	// then
	Assert.assertTrue(schedulerFactoryBean.checkExists(triggerKey));
	Assert.assertTrue(schedulerFactoryBean.checkExists(jobKey));
    }
}