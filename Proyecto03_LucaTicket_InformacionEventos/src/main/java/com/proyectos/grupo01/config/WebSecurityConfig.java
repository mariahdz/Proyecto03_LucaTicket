package com.proyectos.grupo01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.proyectos.grupo01.security.JWTAutenticationFilter;
import com.proyectos.grupo01.security.JWTAuthorizationFilter;



/*
 * @autor Desiree
 * @version 07/07/2021
 * WebSecurityConfig
 */

@EnableWebSecurity
@Configuration

/*	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/user").permitAll()
			.anyRequest().authenticated();
	}*/
	
	
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * Configura el acceso
	 */
		@Override
	      protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests()
	            .antMatchers("/").permitAll()
	            .antMatchers(HttpMethod.POST, "/user").permitAll()
	            .anyRequest().authenticated()
	            .and()
	            // We filter the api/login requests
	            .addFilterBefore(new JWTAutenticationFilter(), UsernamePasswordAuthenticationFilter.class)
	            // And filter other requests to check the presence of JWT in header
            	.addFilterBefore(new JWTAuthorizationFilter(),
                    UsernamePasswordAuthenticationFilter.class);
	      }


	    
	    /*
		 * Se crea una cuenta por defecto
		 */
		@Override
	      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        // Create a default account
	        auth.inMemoryAuthentication()
	            .withUser("john")
	            .password("123")
	            .roles("ADMIN");
	      

	}
}
	
	


