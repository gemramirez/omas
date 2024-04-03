package com.omasystem.omas.Config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class TestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/**").permitAll() // Specify your endpoint(s) here
        .anyRequest().authenticated()
        .and()
        .httpBasic(); // You may need to adjust this depending on your authentication method
    }
}