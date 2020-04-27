package com.harsha.outhuserclientdemo.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration extends WebSecurityConfigurerAdapter {
 
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .antMatchers("/read/**").hasAuthority("SCOPE_resource.read")
        .antMatchers("/write/**").hasAuthority("SCOPE_resource.write")
        .anyRequest().authenticated()
      .and()
        .oauth2ResourceServer().jwt();
   }
   
   
}