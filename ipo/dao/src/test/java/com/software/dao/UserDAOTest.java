/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-dao
 *
 *  @author: Andrzej Piechocki *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 2023-06-10
 *
 *****************************************************/
package com.software.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.software.conf.TestDataContext;
import com.software.dao.user.UserDAO;
import com.software.domain.lookup.PersonalTitleEnum;
import com.software.domain.user.Role;
import com.software.domain.user.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestDataContext.class })
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class UserDAOTest {

    private final static String TEST_USERNAME = "s.muller@test-email.com";
    private final static String TOKEN = "32235235235235235";

    @Autowired
    private UserDAO userDAO;

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void failedLoginLog() {
        this.userDAO.logFailedLogInAttempt(TEST_USERNAME);
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);
        assertNotNull(userProfile);
        assertEquals(userProfile.getFailedAttempts(), (Integer) 1);
        assertNotNull(userProfile.getLastAttemptDate());
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void findByUserName() {
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);
        assertNotNull(userProfile);
        final Set<Role> roles = userProfile.getRoles();
        assertNotNull(roles);
        assertEquals(2, roles.size());
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void successLoginLog() {
        this.userDAO.logSuccessLogInAttempt(TEST_USERNAME);
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);
        assertNotNull(userProfile);
        assertEquals(userProfile.getFailedAttempts(), (Integer) 0);
        assertNotNull(userProfile.getLastAttemptDate());
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestDataWithToken.xml")
    public void getUserByTokenlPositiveScenarioTokenExists() {
        // given
        final Calendar atTheMoment = Calendar.getInstance();
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);
        userProfile.setResetPasswordValidDate(atTheMoment.getTime());
        userDAO.update(userProfile);

        // when
        final UserProfile userProfileR = this.userDAO.findAvailableUniqueProfileByToken(TOKEN);

        // then
        assertNotNull(userProfileR);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestDataWithToken.xml")
    public void getUserByTokenlNegativeScenarioTokenDate() {
        // given
        final Calendar twoDayBefore = Calendar.getInstance();
        twoDayBefore.add(Calendar.DAY_OF_YEAR, -8);
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);
        userProfile.setResetPasswordValidDate(twoDayBefore.getTime());
        userDAO.update(userProfile);

        // when
        final UserProfile userProfileR = this.userDAO.findAvailableUniqueProfileByToken(TOKEN);

        // then
        assertNull(userProfileR);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void getUserByTokenlNegativeScenarioTokenNotExists() {
        // given
        // there is no token in db
        // when
        final UserProfile userProfile = this.userDAO.findAvailableUniqueProfileByToken(TOKEN);

        // then
        assertNull(userProfile);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestDataWithToken.xml")
    public void checkAvailabilityOfResetUrlPositiveScenarioDate() {
        // given
        final Calendar atTheMoment = Calendar.getInstance();
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);
        userProfile.setResetPasswordValidDate(atTheMoment.getTime());
        userDAO.update(userProfile);

        // when
        final boolean isProfileTokenValid = this.userDAO.isProfileTokenValid(TOKEN);

        // then
        assertTrue(isProfileTokenValid);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestDataWithToken.xml")
    public void checkAvailabilityOfResetUrlNegativeScenarioTokenDate() {
        // given
        final Calendar twoDayBefore = Calendar.getInstance();
        twoDayBefore.add(Calendar.DAY_OF_YEAR, -8);
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);
        userProfile.setResetPasswordValidDate(twoDayBefore.getTime());
        userDAO.update(userProfile);

        // when
        final boolean isProfileTokenValid = this.userDAO.isProfileTokenValid(TOKEN);

        // then
        assertFalse(isProfileTokenValid);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void checkAvailabilityOfResetUrlNegativeScenarioTokenNotExists() {
        // given
        final Calendar atTheMoment = Calendar.getInstance();
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);
        userProfile.setResetPasswordValidDate(atTheMoment.getTime());
        userProfile.setToken(null);
        userDAO.update(userProfile);

        // when
        final boolean isProfileTokenValid = this.userDAO.isProfileTokenValid(TOKEN);

        // then
        assertFalse(isProfileTokenValid);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void checkFindingOfUniqueUserByEmailIgnoreCaseSensivityNormalMode() {
        // given
        // when
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME);

        // then
        assertNotNull(userProfile);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void checkFindingOfUniqueUserByEmailIgnoreCaseSensivityUpperCaseMode() {
        // given
        // when
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME.toUpperCase());

        // then
        assertNotNull(userProfile);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void checkFindingOfUniqueUserByEmailIgnoreCaseSensivityLowerCaseMode() {
        // given
        // when
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME.toLowerCase());

        // then
        assertNotNull(userProfile);
    }

    @Test
    @DatabaseSetup("classpath:test/dbTestData.xml")
    public void checkFindingOfUniqueUserByEmailIgnoreCaseSensivityUserNotFound() {
        // given
        // when
        final UserProfile userProfile = this.userDAO.findByUsername(TEST_USERNAME + "-");

        // then
        assertNull(userProfile);
    }

    @Test
    public void createNewUser() {

        final UserProfile userProfile = new UserProfile();
        userProfile.setFirstName("Rafał");
        userProfile.setLastName("Chwastek");
        userProfile.setPassword("test");
        userProfile.setActive(true);
        userProfile.setEmail("andrzej.piechocki@software.com");
        userProfile.setPersonalTitle(PersonalTitleEnum.MR);
        userProfile.setConsultant(Boolean.FALSE);
        userDAO.create(userProfile);

        assertNotNull(userProfile.getId());
    }
}