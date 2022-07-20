package com.example.BaeGongPaServer.Config;

import com.example.BaeGongPaServer.Auth.AuthProvider;
import com.example.BaeGongPaServer.Component.Exception.ExceptionHandlerFilter;
import com.example.BaeGongPaServer.Filter.AuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthProvider authProvider;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

			 	http
			 	.authorizeRequests()
			 	.antMatchers("/img**", "/img/**").permitAll()
			 	.antMatchers("/test**", "/test/**", "/sign**", "/sign**/**").permitAll()
			 	.antMatchers("/user/**").hasAnyRole("ADMIN")
			 	.antMatchers("/admin/**").hasAnyRole("ADMIN")
			 	.anyRequest().authenticated()
			 	.and()
			 	.addFilterBefore(new AuthFilter(authProvider), UsernamePasswordAuthenticationFilter.class)
			 	.addFilterBefore(new ExceptionHandlerFilter(), AuthFilter.class);


    }
}
