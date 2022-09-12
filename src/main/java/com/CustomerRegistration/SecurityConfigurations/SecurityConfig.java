package com.CustomerRegistration.SecurityConfigurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/customers/{id}").authenticated()
			.antMatchers("/users").permitAll()	
			.antMatchers("/customers").authenticated()
			.and()
			.httpBasic();
	}
	 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication()
//			.withUser("kenny").password("13242").authorities("admin")
//			.and()
//			.withUser("user1").password("13432").authorities("user")
//			.and()
//			.passwordEncoder(NoOpPasswordEncoder.getInstance());
//	}
//	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web 
			.ignoring()
			.antMatchers("/h2-console/**");
			//h2 console authorization implementation
	}
}

//InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//
//UserDetails user1 = User.withUsername("kenny").password("12345").authorities("admin").build();
//UserDetails user2 = User.withUsername("prince").password("4321").authorities("user").build();
//userDetailsService.createUser(user1);
//userDetailsService.createUser(user2);
