package pl.inventorybackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.inventorybackend.security.User.UserService;
import pl.inventorybackend.security.session.SessionFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    private final SessionFilter sessionFilter;
    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(UserService userService, SessionFilter sessionFilter, @Lazy PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.sessionFilter = sessionFilter;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();


        http = http.exceptionHandling().authenticationEntryPoint(
                (request, response, ex) -> response.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        ex.getMessage())
        ).and();

        http.authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/inventory/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(
                sessionFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }

}

