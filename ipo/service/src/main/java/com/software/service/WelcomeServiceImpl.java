/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 2023-12-06
 *
 *****************************************************/
package com.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.dao.user.UserDAO;
import com.software.domain.user.UserProfile;

@Service
@Transactional
public class WelcomeServiceImpl
implements WelcomeService {

    @Autowired
    private UserDAO userDao;

    @Override
    public UserProfile getUserProfile(final String userName) {
        return this.userDao.findByUsername(userName);
    }

}
