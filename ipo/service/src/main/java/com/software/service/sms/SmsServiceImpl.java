/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 18-12-2023 *
 *****************************************************/
package com.software.service.sms;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("SmsService")
public class SmsServiceImpl implements SmsService {

    private static final Logger LOGGER = Logger.getLogger(SmsServiceImpl.class);

    @Override
    public void sendSms() {
        LOGGER.info("send sms"); 
    }

    @Override
    public void receiveSms() {
        LOGGER.info("receive sms"); 
    }

}
