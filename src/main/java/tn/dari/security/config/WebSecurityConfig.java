package tn.dari.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import tn.dari.security.PasswordEncoder;
import tn.dari.service.UserService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	 private final UserService userService;
	    private final PasswordEncoder passwordEncoder;
	
	    
	    
	public WebSecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
			super();
			this.userService = userService;
			this.passwordEncoder = passwordEncoder;
		}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/api/v*/registration/**")
     .permitAll()
     .anyRequest()
     .authenticated()
     .and()
     .formLogin();
		 http.csrf().disable();
	        http.headers().frameOptions().disable();
	}
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationProvider());
	    }


	    @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setPasswordEncoder(passwordEncoder.bCryptPasswordEncoder());
	        provider.setUserDetailsService(userService);

	        return provider;
	    }

}