package com.hello.hellospring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hello.hellospring.model.CustomLoginSuccess;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomLoginSuccess customLoginSuccess;

	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests()
				.antMatchers("/user/*")
				.authenticated()
				.antMatchers("/admin/*")
				.hasRole("ROLE_ADMIN")
				.anyRequest()
				.permitAll()
			.and()
				.formLogin()
				.loginPage("/member/login")
				.successHandler(customLoginSuccess)
				.failureUrl("/member/fail")
			.and()
				.logout()
				.logoutUrl("/member/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true);

	}
}
