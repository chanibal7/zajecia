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
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-01
 *
 *****************************************************/
package com.software.service.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserWithSalt extends User {

    private static final long serialVersionUID = -7654340995397840853L;

    private Long              salt;
    private boolean zajeciaUsageAgreement;

    public UserWithSalt(final String username, final String password, final boolean enabled, final boolean accountNonExpired,
            final boolean credentialsNonExpired, final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public UserWithSalt(final String username, final String password, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public boolean iszajeciaUsageAgreement() {
        return zajeciaUsageAgreement;
    }

    public void setzajeciaUsageAgreement(boolean zajeciaUsageAgreementArg) {
        this.zajeciaUsageAgreement = zajeciaUsageAgreementArg;
    }

    public Long getSalt() {
        return this.salt;
    }

    public void setSalt(final Long saltArg) {
        this.salt = saltArg;
    }
}
