/**
 * 
 */
package org.jefecomp.configuration.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jefecomp
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	
	
	
    }
    
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception{
	
    }
    
    
    
    
}
