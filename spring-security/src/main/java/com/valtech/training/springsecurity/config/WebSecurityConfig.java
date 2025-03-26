package com.valtech.training.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		// write all config nd then call build..
		security.cors(cors -> cors.disable());
		security.csrf(csrf -> csrf.disable());
		security.formLogin(formLogin -> formLogin.loginPage("/login")
				.defaultSuccessUrl("/user").failureForwardUrl("/login"));
		security.authorizeHttpRequests(requests -> 
//		requests.anyRequest().anonymous()
		requests.requestMatchers("/hello", "/login", "/logout", "/register","/jsps/*").permitAll()
		.requestMatchers("/changePassword").authenticated()
		.requestMatchers("/admin").hasAnyRole("ADMIN")
		.anyRequest().authenticated()											//anyRequst can only come on last line as it specifies any other request other than specified.
		);
		
		return security.build();
	}
	
//	@Bean
//	public UserDetailsManager userDetailsManager() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.builder().username("scott").password("tiger").roles("USER").build());
//		manager.createUser(User.builder().username("admin").password("admin").roles("USER","ADMIN").build());
//		return manager;
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
//		return NoOpPasswordEncoder.getInstance();
	}
}
