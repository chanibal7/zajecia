/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-webapp
 *
 *  @author: Andrzej Piechocki *           <br/>
 * \*           andrzej.piechocki@software.com*
 *  Created: 2023-02-23
 *
 *****************************************************/
package com.software.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.software.AppConstant;


@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    private static final String HAS_ROLE_USAGE_AGREEMENT_PROVIDER = "hasRole('" + AppConstant.Roles.ROLE_USAGE_AGREEMENT_PROVIDER + "')";

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Bean
    public ZajeciaUsernamePasswordAuthenticationFilter authFilter() throws Exception{
        final ZajeciaUsernamePasswordAuthenticationFilter authFilter = new ZajeciaUsernamePasswordAuthenticationFilter();
        authFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login.htm", "POST"));
        authFilter.setAuthenticationManager(this.authenticationManager());
        authFilter.setAuthenticationSuccessHandler(new SavedRequestAwareAuthenticationSuccessHandler());
        authFilter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/login.htm?error"));
        authFilter.setUsernameParameter("username");
        authFilter.setPasswordParameter("password");
        return authFilter;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception  {

        // @formatter:off
        http.authorizeRequests()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/change-password.htm").authenticated()
        .antMatchers("/contact.htm").authenticated()
        .antMatchers("/privacy.htm").authenticated()
        .antMatchers("/welcome.htm").access("hasRole('" + AppConstant.Roles.ROLE_PROJECT_MANAGER + "')")
        .antMatchers("/usage-agreement.htm").access(HAS_ROLE_USAGE_AGREEMENT_PROVIDER)
        .antMatchers("/accept-usage-agreement.htm").access(HAS_ROLE_USAGE_AGREEMENT_PROVIDER).and()
        .formLogin().loginPage("/login.htm").permitAll().and()
        .logout().deleteCookies("JSESSIONID").invalidateHttpSession(true).and()
        .csrf().disable();
        http.addFilterBefore(this.authFilter(), UsernamePasswordAuthenticationFilter.class);
        //@formatter:on
    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setPasswordEncoder(passwordEncoder);
        authProvider.setUserDetailsService(this.userDetailsService);
        final ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("getSalt");
        authProvider.setSaltSource(saltSource);
        auth.authenticationProvider(authProvider);
    }
}