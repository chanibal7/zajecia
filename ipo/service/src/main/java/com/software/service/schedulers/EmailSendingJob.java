/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 2023-12-17
 *
 *****************************************************/
package com.software.service.schedulers;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.software.service.email.EmailService;

public class EmailSendingJob implements Job {

    @Autowired
    private EmailService emailService;

    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        emailService.sendResetPasswordEmail(null, "smttest2023gmail.com"); // TODO adjust logic here (loading emails list
        // etc...) it's only template at the moment
    }

}