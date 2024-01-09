package com.example.howIsIt.config;

import com.example.howIsIt.filter.JwtFilter;
import com.example.howIsIt.util.FirebaseUserDetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private FirebaseAuth firebaseAuth;

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//
//        // 사용자 정보 조회 쿼리 설정
//        manager.setUsersByUsernameQuery("select id from users where uid = ?");
//        //manager.setAuthoritiesByUsernameQuery("SELECT uid, authority FROM authorities WHERE uid = ?");
//
//        return manager;
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
                try {
                    String username = uid;
                    // 사용자 권한 등의 추가 정보를 설정하거나, UserDetails를 구현한 클래스를 사용
                    return new FirebaseUserDetails(username);
                } catch (Exception e) {
                    throw new UsernameNotFoundException("Firebase User Not Found", e);
                }
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
//        http
//                // CSRF 설정을 비활성화합니다.
//                .csrf(csrf -> csrf.disable())
//                // 요청에 대한 권한을 설정합니다.
//                .authorizeRequests(authorize -> authorize
//                        .requestMatchers(new AntPathRequestMatcher("/users", "POST")).permitAll()
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

        http
                .authorizeRequests()
                .anyRequest().permitAll()
                // 나머지 보안 설정
                .and()
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
