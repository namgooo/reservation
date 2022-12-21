package com.green.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.green.sbb.service.UserSecurityService;

import lombok.RequiredArgsConstructor;

@EnableGlobalMethodSecurity(securedEnabled = true) // secured 활성화
@RequiredArgsConstructor
@Configuration 			// @Configuration : 시큐리티 환경설정 파일임을 의미(시큐리티 설정을 위해 사용)
@EnableWebSecurity		// @EnableWebSecurity : 모든 요청 url이 스프링 시큐리티에 제어받게 만듬(내부적으로 SecurityFilterChain이 동작함)
public class SecurityConfig {

	private final UserSecurityService userSecurityService;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests() // 요청을 설정하겠음
        	.antMatchers("/").permitAll() // main페이지의 모든 사용자의 요청을 허용하겠음
        	.antMatchers("/review/**").hasRole("USER")
        	.antMatchers("/reservation/**").hasRole("USER")
        	.antMatchers("/mypage/**").hasRole("USER")
        	.antMatchers("/manager/**").hasRole("ADMIN")
        .and()
        	.formLogin()
        	.loginPage("/user/login")
        	//.loginProcessingUrl("/user/login")
        	.defaultSuccessUrl("/")
        .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
        
        ;
        
        return http.build();
    }
    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

	
}
