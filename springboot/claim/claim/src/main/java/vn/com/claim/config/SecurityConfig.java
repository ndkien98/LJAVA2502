package vn.com.claim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 3.1
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //3.2 tạo config security filter chain

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> { // config các request
                    request.requestMatchers("/cms/claim-manager").hasAnyRole("USER")
                            .requestMatchers("/cms/**").hasAnyRole("ADMIN") // tất cả các đường đãn bắt từ từ /cms/ đều phải có role ADMIN mới được truy cập vào
                            .requestMatchers("/","/home","/login","/logout","/process_login").permitAll()// tất cả các đường dẫn này có thể truy cạp mà không càn login
                            .requestMatchers(
                                    "/assets/**", "/fonts/**", "/homeguest_files/**",
                                    "/js/**", "/libs/**", "/loginmetlife/**",
                                    "/page404/**", "/scss/**", "/tasks/**", "/css/**", "/images/**","/cms-rs/**","/file/**","/api/claim/create").permitAll()
                            .requestMatchers("/resource/**").permitAll()
                            .requestMatchers("/auth/**").permitAll()
                            .requestMatchers("/kaira/**").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin( // custom form login, không sử dụng form login mặc định của spring security
                        form ->
                                form.loginPage("/login")// page login được custom
                                        .loginProcessingUrl("/process_login") // url để view gửi username, password lên cho server, config tại form login ở page login
                                        .defaultSuccessUrl("/handle-login-success", true)
                                        .failureUrl("/login?error=true")
                )
                .logout(logout ->
                        logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll());
        return http.build();
    }


    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
        System.out.println(encoder.encode("user"));
    }
}
