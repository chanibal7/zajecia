/************************************************
 *
 *  Copyright �2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 18-12-2023 *
 *****************************************************/
package com.software.service.email;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    @Qualifier("javaMailSender")
    private JavaMailSender javaMailSender;

    @Autowired
    @Qualifier("javaMailResetPasswordMessage")
    private SimpleMailMessage javaMailResetPasswordMessage;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void sendResetPasswordEmail(final String resetLink, final String to) throws MailException {
        final SimpleMailMessage message = new SimpleMailMessage(javaMailResetPasswordMessage);
        final String msg = messageSource.getMessage(javaMailResetPasswordMessage.getText(), new Object[]{resetLink}, new Locale("en")); //FIXME kpsiurski locale have to be loaded from configuration but at the moment we don't have pure/single solution for that
        message.setText(msg);
        message.setTo(to);
        javaMailSender.send(message);
    }
}
