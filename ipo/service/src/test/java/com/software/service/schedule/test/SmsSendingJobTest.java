/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 18-Andrzej.Piechocki2023 *
 *****************************************************/
package com.software.service.schedule.test;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.quartz.Job;
import org.quartz.JobExecutionException;

import com.software.service.schedulers.SmsSendingJob;
import com.software.service.sms.SmsService;

@RunWith(MockitoJUnitRunner.class)
public class SmsSendingJobTest {

    @Mock
    SmsService smsService;

    @InjectMocks
    Job smsSendingJob = new SmsSendingJob();

    @Test
    public void checkInvocationOfMailingService() throws JobExecutionException {

	// when
	this.smsSendingJob.execute(null);

	// then
	Mockito.verify(smsService, times(1)).sendSms();
    }

    @Before
    public void setup() {
	MockitoAnnotations.initMocks(this);
    }

}
