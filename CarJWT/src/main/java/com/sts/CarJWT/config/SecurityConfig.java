package com.sts.CarJWT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final UnauthorizedEntryPoint unauthorizedEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UnauthorizedEntryPoint unauthorizedEntryPoint,
                          JwtAuthenticationFilter jwtAuthenticationFilter,
                          UserDetailsService userDetailsService) {
        this.unauthorizedEntryPoint = unauthorizedEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .requestMatchers(new AntPathRequestMatcher("/users/authenticate"), new AntPathRequestMatcher("/users/register")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/users/adminping")).hasRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/users/find/all")).hasRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/users/find/by/username")).hasRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/users/userping")).hasRole("USER")
                .requestMatchers(new AntPathRequestMatcher("/carproduct/add")).hasRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/carproduct/carlist")).hasAnyRole("ADMIN", "USER")
                .requestMatchers(new AntPathRequestMatcher("/carproduct/carsearch/**")).hasAnyRole("ADMIN", "USER")
                .requestMatchers(new AntPathRequestMatcher("/carproduct/carupdate/*")).hasRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/carproduct/cartpatch/*")).hasRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/carproduct/**")).hasRole("ADMIN")

                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint)
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

   /* @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
