package com.mitesh.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;


	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);


		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		//we are trying to log in with plane pass and Bcrypt is working 

		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(customizer->customizer.disable());
		//by doing this we are disabling CSRF token

		http.authorizeHttpRequests(request->request.anyRequest().authenticated());
		//we have open all security authetication requests

		http.httpBasic(Customizer.withDefaults());
		//by doing this we are enabling login form

		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//we are making stateless means every time we refresh we will get new session

		return http.build();
	}



	/*@Bean
	public UserDetailsService userDetailsService(){
		UserDetailsService user= (UserDetailsService) User
				.withDefaultPasswordEncoder()
				.username("Mitesh")
				.password("M@123")
				.roles("USER")
				.build();

		UserDetailsService admin= (UserDetailsService) User
				.withDefaultPasswordEncoder()
				.username("Admin")
				.password("A@123")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager((UserDetails) user, (UserDetails) admin);
	}*/
}