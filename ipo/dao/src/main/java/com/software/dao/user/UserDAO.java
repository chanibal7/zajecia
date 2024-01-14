/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-dao
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-02-20
 *
 *****************************************************/
package com.software.dao.user;

import com.software.dao.BaseDAO;
import com.software.domain.user.UserProfile;

public interface UserDAO extends BaseDAO<UserProfile> {

    UserProfile findByUsername(String userName);

    void logSuccessLogInAttempt(String userName);

    int logFailedLogInAttempt(String userName);

    public UserProfile findAvailableUniqueProfileByToken(final String token);

    boolean isProfileTokenValid(String token);
}