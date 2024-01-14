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
 *  Created: 2023-12-06
 *
 *****************************************************/
package com.software.service.test;

import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.software.dao.user.UserDAO;
import com.software.domain.user.UserProfile;
import com.software.service.WelcomeService;
import com.software.service.WelcomeServiceImpl;

/**
 * Test class for service {@link com.software.service.WelcomeServiceImpl welcomeService}
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class WelcomeServiceImplTest {

    @Mock
    UserDAO        userDao;

    @InjectMocks
    WelcomeService welcomeService = new WelcomeServiceImpl();

    @Test
    public void checkFindByUserName() {

        // given
        final UserProfile userProfile = new UserProfile();
        Mockito.when(this.userDao.findByUsername(anyString())).thenReturn(userProfile);

        // when
        final UserProfile userProfileDB = this.welcomeService.getUserProfile("test");

        // then
        assertSame(userProfile, userProfileDB);
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
