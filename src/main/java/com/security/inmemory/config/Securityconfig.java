package com.security.inmemory.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class Securityconfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("prem").password("{noop}prem").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("mike").password("{noop}mike").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("ross").password("{noop}ross").authorities("STUDENT");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/std").hasAnyAuthority("STUDENT")
		
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome")
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/deniedpage")
		
		
		
		;
		
			}

}
