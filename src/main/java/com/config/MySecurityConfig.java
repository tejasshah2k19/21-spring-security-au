package com.config;
// .xml 

import org.springframework.beans.factory.annotation.Autowired;

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
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.service.CustomUsersDetailService;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;

@Configurable
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUsersDetailService customUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests().antMatchers("/signup").permitAll().anyRequest().authenticated().and().httpBasic().and().antMatcher("/signup");
//	
		// authority -- role
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests()
				.antMatchers("/public/**").permitAll().antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/users/**").hasRole("USER").anyRequest().authenticated().and().formLogin()
				.loginPage("/public/login").defaultSuccessUrl("/users/home");
		// .usernameParameter("email");
//				;
	}

	// we want to add our username and password
	// our own credentials

	// 1) InMemoryDataBase
	// 2) DB

	// inMemory
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("tejas").password(this.passwordEncoder().encode("tejas123"))
//				.roles("USER");// ROLE_USER
//		auth.inMemoryAuthentication().withUser("prisha").password(this.passwordEncoder().encode("tejas123"))
//				.roles("ADMIN");// ROLE_ADMIN
//	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(this.passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder(10);// object
	}
	// tejas123
}
