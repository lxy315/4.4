package com.feiyi.heritage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests(auth -> auth
                // 完全公开的API
                .antMatchers("/api/public/**", "/api/auth/**", "/api/register", "/api/login").permitAll()
                
                // 需要USER角色的API
                .antMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
                
                // 需要ADMIN角色的API  
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                
                // 其他所有请求需要认证（不区分角色）
                .anyRequest().authenticated()
            )
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            // 禁用表单登录和HTTP Basic（适合纯API项目）
            .formLogin().disable()
            .httpBasic().disable();
        
        return http.build();
    }
}