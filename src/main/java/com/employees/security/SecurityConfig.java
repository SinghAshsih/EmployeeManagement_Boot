package com.employees.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilters(HttpSecurity http) throws Exception {

		return http.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests(
						request -> request.requestMatchers("/all").permitAll().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();

	}

	/*
	 * @Bean public UserDetailsService userDetailService() { UserDetails user1 =
	 * User.withDefaultPasswordEncoder().username("Ashish").password("@Ashish").
	 * build();
	 * 
	 * UserDetails user2 =
	 * User.withDefaultPasswordEncoder().username("Ram").password("@Ram").build();
	 * 
	 * return new InMemoryUserDetailsManager(user1, user2); }
	 */

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);

		return provider;
	}

}
