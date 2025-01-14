package com.project.robotmate.admin.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.httpBasic().disable()
//                .csrf().disable();
//        return http.build();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**","/fonts/**", "/images/**","/js/**", "/login").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/galleries")
                .usernameParameter("adminId")
                .and()
                .logout();
        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webFilterChain() {
        return (web) -> web.ignoring().antMatchers("/css/**", "/img/**","/vendor/**","/js/**");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
