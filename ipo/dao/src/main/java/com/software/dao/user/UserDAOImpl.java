/************************************************
 *
 *  Copyright �2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-dao
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-10
 *
 *****************************************************/
package com.software.dao.user;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.software.domain.user.QUserProfile;
import com.software.dao.BaseDAOImpl;
import com.software.domain.user.UserProfile;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<UserProfile> implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Override
    public UserProfile findByUsername(final String userName) {

        final List<UserProfile> users = em.createQuery("SELECT ua FROM UserProfile ua WHERE ua.email = :userName AND ua.active=true")
                .setParameter("userName", userName.toLowerCase())
                .getResultList();

        if (users.size() == 1) {
            return users.get(0);
        } else if (users.size() > 1) {
            LOGGER.error("For username: " + userName + " founded more than 1 row");
        }
        return null;
    }


    @Override
    public UserProfile findAvailableUniqueProfileByToken(final String token) {
        final QUserProfile userProfile = QUserProfile.userProfile;
        final JPAQuery jpaQuery = new JPAQuery(em);
        return jpaQuery.from(userProfile).where(tokenValid7dayExpression(token, userProfile)).uniqueResult(userProfile);
    }

    private BooleanExpression tokenValid7dayExpression(final String token, final QUserProfile userProfile) {
        final Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_YEAR, -7);
        return userProfile.token.eq(token).and(userProfile.resetPasswordValidDate.after(now.getTime()));
    }

    private int logAttempt(final String userName, final boolean resetFailedCounter) {

        final UserProfile userProfile = this.findByUsername(userName);
        if (userProfile == null) {
            return 0;
        }

        if (resetFailedCounter) {
            userProfile.setFailedAttempts(0);
        } else {
            Integer failedAttemptsCounter = userProfile.getFailedAttempts();
            if (failedAttemptsCounter == null) {
                failedAttemptsCounter = 0;
            }

            userProfile.setFailedAttempts(failedAttemptsCounter + 1);
        }

        userProfile.setLastAttemptDate(new Date());
        this.em.persist(userProfile);
        this.em.flush();
        return userProfile.getFailedAttempts();
    }

    @Override
    @Transactional
    public int logFailedLogInAttempt(final String userName) {
        return this.logAttempt(userName, false);
    }

    @Override
    @Transactional
    public void logSuccessLogInAttempt(final String userName) {
        this.logAttempt(userName, true);
    }

    @Override
    public boolean isProfileTokenValid(final String token) {
        final QUserProfile userProfile = QUserProfile.userProfile;
        final JPAQuery jpaQuery = new JPAQuery(em);
        return jpaQuery.from(userProfile).where(tokenValid7dayExpression(token, userProfile)).exists();
    }
}