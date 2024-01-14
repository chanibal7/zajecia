/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-webapp
 *
 *  @author: Andrzej Piechocki           <br/>
 *\*           andrzej.piechocki@software.com *
 *  Created: 2023-12-23
 *
 *****************************************************/
package com.software.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sofware.conf.MailConf;

@Configuration
@Import({ DataContext.class, ViewConf.class, SecurityConf.class, JobsConf.class, MailConf.class })
public class AppConf {
}
