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

        http
                .authorizeRequests()
                .anyRequest().permitAll()
                // 나머지 보안 설정
                .and()
                .csrf(csrf -> csrf.disable());
//        http
//                // 요청에 대한 권한을 설정합니다.
//                .authorizeRequests()
//                .antMatchers("/users/**").permitAll() // '/users/**' 경로는 모두 허용
//                .anyRequest().authenticated()
//                .and()
//                // 예외 처리를 구성합니다.
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .and()
//                // JwtFilter를 SecurityFilterChain에 추가합니다.
//                .addFilterBefore(new JwtFilter(userDetailsService, firebaseAuth), UsernamePasswordAuthenticationFilter.class)
//                .csrf().disable(); // CSRF 보호를 비활성화
        return http.build();
    }
}
