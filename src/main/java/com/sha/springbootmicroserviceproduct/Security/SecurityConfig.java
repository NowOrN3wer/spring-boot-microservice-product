package com.sha.springbootmicroserviceproduct.Security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Value("${service.security.secure-key-username}")
    private String SECURE_USER_NAME;
    @Value("${service.security.secure-key-password}")
    private String SECURE_USER_PASSWORD;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().
                passwordEncoder(pe).
                withUser(SECURE_USER_NAME).
                password(pe.encode(SECURE_USER_PASSWORD)).
                roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
    }
}
