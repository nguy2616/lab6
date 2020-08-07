package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by CoT on 11/12/17.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("henry").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");

        auth.userDetailsService(getUserDetailsService());

    }

    @Bean
    public MyUserDetailsService getUserDetailsService(){
        return new MyUserDetailsService();
    }

    //this is the MOST important one
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//    }

    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/patients").access("hasRole('ROLE_USER') or hasRole('ROLE_DBA') or hasRole('ROLE_ADMIN')")

                .and().httpBasic()
                .and().csrf().disable();

    }
}
