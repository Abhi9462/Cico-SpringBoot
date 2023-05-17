package com.cico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cico.Filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserDetailsService detailService;
	
	@Autowired
	AuthenticationEntryPoint entryPoint;
	
	@Autowired
	SecurityFilter filter;
	
	@Bean	
	public AuthenticationManager manager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder);
		provider.setUserDetailsService(detailService);
		
		return provider;		
	}

	
	@Bean
	public SecurityFilterChain chain(HttpSecurity security) throws Exception {
		return security.csrf().disable().authorizeRequests()
				.antMatchers("/student/**").permitAll()
				.anyRequest().authenticated()
				.and().exceptionHandling()
				.authenticationEntryPoint(entryPoint)
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
}
