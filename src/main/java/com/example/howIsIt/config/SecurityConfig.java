package com.example.howIsIt.config;

import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private FirebaseAuth firebaseAuth;

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        // 사용자 정보 조회 쿼리 설정
        manager.setUsersByUsernameQuery("SELECT NICKNAME, EMAIL FROM users WHERE UID = ?");
        //manager.setAuthoritiesByUsernameQuery("SELECT uid, authority FROM authorities WHERE uid = ?");

        return manager;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
//        http
//                // CSRF 설정을 비활성화합니다.
//                .csrf(csrf -> csrf.disable())
//                // 요청에 대한 권한을 설정합니다.
//                .authorizeRequests(authorize -> authorize
//                        // '/users' 경로에 대해 POST 요청은 인증 없이 허용합니다.
//                        .requestMatchers(new AntPathRequestMatcher("/users", "POST")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
//                        // 그 외의 모든 요청은 인증이 필요합니다.
//                        .anyRequest().authenticated()
//                )
//                // 예외 처리를 구성합니다.
//                .exceptionHandling(exception -> exception
//                        // 인증되지 않은 요청에 대해 401 오류를 반환합니다.
//                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                )
//                // JwtFilter를 SecurityFilterChain에 추가합니다.
//                .addFilterBefore(new JwtFilter(userDetailsService, firebaseAuth), UsernamePasswordAuthenticationFilter.class);
//
//        // HttpSecurity 객체를 빌드합니다.
//        return http.build();
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                // 나머지 보안 설정
                .and()
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
