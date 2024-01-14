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
 *  Created: 20-12-2023
 *
 *****************************************************/
package com.sofware.conf;

import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailConf{

    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    @Autowired
    private Environment env;

    @Autowired
    private MessageSource messageSource;


    @Bean
    public JavaMailSender javaMailSender() {
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        final Properties mailProperties = new Properties();
        mailProperties.put(MAIL_SMTP_AUTH, env.getProperty(MAIL_SMTP_AUTH));
        mailProperties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
        mailSender.setJavaMailProperties(mailProperties);
        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setPort(Integer.valueOf(env.getProperty("mail.port")));
        mailSender.setProtocol(env.getProperty("mail.protocol"));
        mailSender.setUsername(env.getProperty("mail.username"));
        mailSender.setPassword(env.getProperty("mail.password"));
        return mailSender;
    }

    @Bean
    public SimpleMailMessage javaMailResetPasswordMessage() {
        final SimpleMailMessage mailTemplate = new SimpleMailMessage();
        mailTemplate.setFrom(env.getProperty("mail.from"));
        mailTemplate.setSubject(messageSource.getMessage("login.reset.email.subject", null, new Locale("en"))); //FIXME kpsiurski locale have to be loaded from configuration/db but at the moment we don't have pure/single solution for that
        mailTemplate.setText("login.reset.email.body");
        return mailTemplate;
    }
}