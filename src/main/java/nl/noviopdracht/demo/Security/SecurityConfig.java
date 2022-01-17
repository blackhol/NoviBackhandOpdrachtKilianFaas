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
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}appel").roles("USER")
                .and().withUser("admin").password("{noop}peer").roles("USER","ADMIN")
                .and().withUser("mechanic").password("{noop}wrench").roles("MECH","ADMIN")
                .and().withUser("cashier").password("{noop}register").roles("CASH","ADMIN")
                .and().withUser("backofficeworker").password("{noop}computer").roles("BACK","ADMIN")
                .and().withUser("admassistant").password("{noop}cellphone").roles("ADMA","ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .defaultSuccessUrl("/").and().authorizeRequests()
                .antMatchers("/secret/**").hasRole("ADMIN")
                .antMatchers("/public/**").hasRole("USER")
                .antMatchers("/public/**").hasRole("MECH")
                .antMatchers("/public/**").hasRole("CASH")
                .antMatchers("/public/**").hasRole("BACK")
                .antMatchers("/public/**").hasRole("ADMA")
                .antMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and().httpBasic();




    }

}
