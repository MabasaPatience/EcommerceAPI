package ecommerceapi.com.ecommerceapi.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] ADMIN_SECURED_URLS={"/user/get"};

    private static final String[] CUSTOMER_SECURED_URLS={"/role/get"};
    private static final String[] UNSECURED_URLS={"/user/save","/role/**"};

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(UNSECURED_URLS)
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(ADMIN_SECURED_URLS).hasAuthority("admin")
                .and()
                .authorizeHttpRequests()
                .requestMatchers(CUSTOMER_SECURED_URLS).hasAuthority("user")
                .anyRequest()
                .authenticated().and()
                .formLogin().and().httpBasic().and().build();
    }
}
