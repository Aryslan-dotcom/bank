package Kaspi.bank.config;

import Kaspi.bank.Users.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    UserService userService(){
        return new UserService();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userService())
                .passwordEncoder(passwordEncoder());
        http.exceptionHandling().accessDeniedPage("/bank/403");
        http.formLogin()
                .loginPage("/bank/login")
                .loginProcessingUrl("/sign-in")
                .usernameParameter("user-email")
                .passwordParameter("user-password")
                .defaultSuccessUrl("/bank/profile")
                .failureUrl("/bank/login?error");
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/bank/home");
        http.csrf().disable();
        return http.build();
    }

}
