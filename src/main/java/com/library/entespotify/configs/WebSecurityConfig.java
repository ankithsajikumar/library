package com.library.entespotify.configs;

import com.library.entespotify.filters.TokenAuthenticationEntryPoint;
import com.library.entespotify.filters.TokenRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private final UserDetailsService userDetailsService;

    @Autowired
    private final TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint;

    @Autowired
    private final TokenRequestFilter tokenRequestFilter;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    public WebSecurityConfig(UserDetailsService userDetailsService, TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint, TokenRequestFilter tokenRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.tokenAuthenticationEntryPoint = tokenAuthenticationEntryPoint;
        this.tokenRequestFilter = tokenRequestFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000/"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT", "OPTIONS", "PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/authenticate/register", "/authenticate", "/authenticate/refresh", "/h2-console/*").anonymous()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(tokenAuthenticationEntryPoint)
                .and()
                .csrf().disable().cors().configurationSource(request -> corsConfiguration)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(tokenRequestFilter, UsernamePasswordAuthenticationFilter.class);

        if (activeProfile.equals("default")) {
            //for h2 console to show up
            http.headers().frameOptions().disable();
        }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
