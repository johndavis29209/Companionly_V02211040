package com.companionly.prototype.controllers;

import com.companionly.prototype.services.CustomLoginSuccessHandler;
import com.companionly.prototype.services.CustomUserDetailsService;
import com.companionly.prototype.data.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CustomUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http,
                                         CustomLoginSuccessHandler customLoginSuccessHandler,
                                         UserDetailsService userDetailsService,
                                         PasswordEncoder passwordEncoder) throws Exception {

        DaoAuthenticationProvider authenticationProvider = authenticationProvider(userDetailsService, passwordEncoder);
        http.authenticationProvider(authenticationProvider);

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/login", "/processLogin", "/error", "/images/**").permitAll()
                .requestMatchers("/list_users", "/home").authenticated()
                .requestMatchers("/api/posts/**", "/api/replies/**").permitAll()
                .requestMatchers("/forum/**").permitAll()
                .anyRequest().permitAll()
        );

        http.csrf(csrf -> csrf
                .ignoringRequestMatchers("/api/posts/**", "/api/replies/**", "/forum/**")
        );

        http.formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/processLogin")
                .successHandler(customLoginSuccessHandler)
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll()
        );

        http.logout(logout -> logout
                .logoutSuccessUrl("/").permitAll()
        );

        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        );

        // *** Add the frameOptions SAMEORIGIN here ***
        http.headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin())
        );

        return http.build();
    }

}
