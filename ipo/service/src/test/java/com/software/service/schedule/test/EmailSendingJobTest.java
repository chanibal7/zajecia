/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 18-12-2023
 *
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

import com.software.service.email.EmailService;
import com.software.service.schedulers.EmailSendingJob;

@RunWith(MockitoJUnitRunner.class)
public class EmailSendingJobTest {

    @Mock
    EmailService emailService;

    @InjectMocks
    Job emailSendingJob = new EmailSendingJob();

    @Test
    public void checkInvocationOfMailingService() throws JobExecutionException {

	// when
	this.emailSendingJob.execute(null);

	// then
	Mockito.verify(emailService, times(1)).sendResetPasswordEmail(null, "smttest2023@gmail.com");
    }

    @Before
    public void setup() {
	MockitoAnnotations.initMocks(this);
    }

}
