package com.cognizant.smartshopservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.smartshopservice.security.AppUserDetailsService;
import com.cognizant.smartshopservice.security.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/smart-shop").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/users/U").permitAll()
				.antMatchers(HttpMethod.POST, "/**").permitAll()
				.antMatchers("/users/A").permitAll()
				.antMatchers("/search-box").permitAll()
				.antMatchers(HttpMethod.GET, "/**").permitAll()
				.antMatchers("/search-box").permitAll()
				.antMatchers(HttpMethod.POST, "/**").permitAll()
				.antMatchers("/search-box").permitAll()
				.antMatchers(HttpMethod.DELETE, "/**").permitAll()
//				.antMatchers("/search-box/appliances").permitAll()
//				.antMatchers(HttpMethod.POST, "/**").permitAll()
//				.antMatchers("/search-box/grocery").permitAll()
//				.antMatchers(HttpMethod.POST, "/**").permitAll()
//				.antMatchers("/search-box/fashion").permitAll()
//				.antMatchers(HttpMethod.POST, "/**").permitAll()
//				.antMatchers("/searchbox/A2").permitAll()
//				.antMatchers(HttpMethod.POST, "/**").permitAll()
				.antMatchers("/authenticate").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated().and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager()));

	}
}