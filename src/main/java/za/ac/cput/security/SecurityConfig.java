package za.ac.cput.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("truck").password("123").roles(ADMIN_ROLE, USER_ROLE)
                .and()
                .withUser("thomas")
                .password("321")
                .roles(USER_ROLE);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/rental/create").hasRole(USER_ROLE) // Allow users to create rental bookings
                .antMatchers("/admin/**").hasRole(ADMIN_ROLE) // Allow admins to access all admin-related endpoints
                .antMatchers("/customer/**").hasRole(ADMIN_ROLE) // Allow customer to access all customer-related endpoints
                .antMatchers("/payment/**").hasRole(ADMIN_ROLE) // Allow payment to access all payment-related endpoints
                .antMatchers("/truck/**").hasRole(ADMIN_ROLE) // Allow truck to access all truck-related endpoints
                .antMatchers("/brand/**").hasRole(ADMIN_ROLE) // Allow brand to access all brand-related endpoints
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}