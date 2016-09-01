package org.nzcn.landing.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by kinlin on 8/27/16.
 */
@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers(HttpMethod.GET, "/item").permitAll()
                .antMatchers(HttpMethod.GET, "/item/**").permitAll()
                .anyRequest().authenticated().and().
                httpBasic().and().
                csrf().disable();
    }

}