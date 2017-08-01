package com.arch;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 DataSource dataSource;
 

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**","/assets/**", "/register","/","/login").permitAll()
                	.antMatchers("/admin/**").hasAnyRole("ADMIN")
					.antMatchers("/rest/**").hasAnyRole("USER")
					.antMatchers("/user/**").hasAnyRole("USER")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password").
                    defaultSuccessUrl("/user" ,true)
                    .permitAll()
                    .and()
                .logout().logoutSuccessUrl("/logout") 
                    .permitAll().and().csrf();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	// ************ memory ********************
//    	auth.inMemoryAuthentication()
//        .withUser("user").password("password").roles("USER")
//        .and()
//        .withUser("admin").password("password").roles("ADMIN");
    	// ************** from database *******************
    	 auth.jdbcAuthentication().dataSource(dataSource).
    	 passwordEncoder(passwordencoder())
    	  .usersByUsernameQuery(
    	   "select username,password, enabled from users where username=?")
    	  .authoritiesByUsernameQuery(
    	   "select username, role from user_roles where username=?");
    
    }
    
    // ***********************  to encrypt password ******************
    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
    	return new BCryptPasswordEncoder();
    	}
}