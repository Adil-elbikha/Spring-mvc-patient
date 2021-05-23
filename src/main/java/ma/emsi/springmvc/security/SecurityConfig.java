package ma.emsi.springmvc.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import groovy.util.ConfigBinding;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncorder=passwordEncorder();
		System.out.println(passwordEncorder.encode("1234"));
		//authentication jdbc
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
		.authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=? ")
		.passwordEncoder(passwordEncorder)
		.rolePrefix("ROLE_");
			
			
		
		
		
		
		//memero authentication
		/*
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncorder.encode("1234")).roles("USER");
		auth.inMemoryAuthentication().withUser("user2").password(passwordEncorder.encode("1234")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncorder.encode("1234")).roles("USER","ADMIN");
		*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/admin/**","/save**/**","/delete**/**,/form**/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/patients**/**").hasRole("USER");
		//http.authorizeRequests().anyRequest().authenticated();
		//http.csrf();
		http.authorizeRequests().antMatchers("/user/**","/login","/webjars/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.exceptionHandling().accessDeniedPage("/notAuthorized");
	}
	@Bean
	public PasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}
}
