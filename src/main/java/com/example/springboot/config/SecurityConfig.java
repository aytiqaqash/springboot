package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final  PasswordConfig passwordConfig;
//
//    public SecurityConfig(PasswordConfig passwordConfig) {
//        this.passwordConfig = passwordConfig;
//    }

    private  PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index", "/css/*", "/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails ziya = User.builder()
                .username("ziya")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build();

        UserDetails aytiqaqash = User.builder()
                .username("aytiqaqash")
                .password(passwordEncoder.encode("password"))
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(ziya,aytiqaqash);
    }
}
