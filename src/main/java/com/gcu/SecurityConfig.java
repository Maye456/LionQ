package com.gcu;

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

import com.gcu.business.UserBusinessService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	// To Hash Passwords
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// To Manipulate the Users
	@Autowired
	UserBusinessService service;
	
	// To Hash Passwords
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	// Security Configurations
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()    
        .formLogin()
            .loginPage("/login/")
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
            .defaultSuccessUrl("/post/all", true)
            .and()
        .authorizeRequests()
		// Put most restricted pages first. Only ADMIN can delete or edit orders
			//.antMatchers("/user/admin").hasRole("ADMIN")
			//.antMatchers("/orders/addNewForm").hasAnyRole("ADMIN", "MANAGER")
            .antMatchers(
                "/",
                "/index",
                "/index/**",
                "/assets/**",
                "displayOauthCode",
                "/register/",
                "/register/**",
                "/login/",
                "/login/**",
                "/img/**",
                "/#"
            ).permitAll()
            .anyRequest().authenticated()
            .and()
        .logout()
            .logoutUrl("/logout")
            .deleteCookies("uid", "username", "password")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .permitAll()
            .logoutSuccessUrl("/");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		String password = new BCryptPasswordEncoder().encode("@Password1234");
		System.out.println("Encrypted value of 123: " + password);
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
	}
}
