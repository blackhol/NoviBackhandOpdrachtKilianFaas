package nl.noviopdracht.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}appel").roles("USER").and().withUser("admin").password("{noop}peer").roles("USER","ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .defaultSuccessUrl("/").and().authorizeRequests()
                .antMatchers("/secret/**").hasRole("ADMIN")
                .antMatchers("/public/**").hasRole("USER")
                .antMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and().httpBasic();




    }

}
