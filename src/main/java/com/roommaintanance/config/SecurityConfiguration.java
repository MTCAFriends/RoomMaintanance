package com.roommaintanance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.roommaintanance.dao.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	    @Qualifier("customUserDetailsService")
	  CustomUserDetailsService userDetailsService;
 
	  @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
    	http.authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/home/**").access("hasRole('ADMIN')")
        .and().formLogin().loginPage("/login")
        .defaultSuccessUrl("/home")
        .usernameParameter("j_username").passwordParameter("j_password")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
  
    }
}