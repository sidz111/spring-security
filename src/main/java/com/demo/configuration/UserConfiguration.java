package com.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class UserConfiguration {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
		
		InMemoryUserDetailsManager detailsManager =new InMemoryUserDetailsManager(user, admin);
		return detailsManager;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/admin")
		.hasRole("ADMIN")
		.requestMatchers("/user")
		.hasRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
	}
}
