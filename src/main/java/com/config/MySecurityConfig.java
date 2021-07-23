package com.config;
// .xml 

// .properties 
// .java 

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;

@Configurable
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests().antMatchers("/signup").permitAll().anyRequest().authenticated().and().httpBasic().and().antMatcher("/signup");
//	

		http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest().authenticated().and().httpBasic();
	}

	// we want to add our username and password
	// our own credentials

	// 1) InMemoryDataBase
	// 2) DB

	// inMemory
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("tejas").password(this.passwordEncoder().encode("tejas123"))
				.roles("USER");// ROLE_USER
		auth.inMemoryAuthentication().withUser("prisha").password(this.passwordEncoder().encode("tejas123"))
				.roles("ADMIN");// ROLE_ADMIN
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder(10);// object
	}
	// tejas123
}
