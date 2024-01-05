package com.example.howIsIt.filter;

import com.google.firebase.auth.FirebaseAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private UserDetailsService userDetailsService;
    private FirebaseAuth firebaseAuth;

    public JwtFilter(UserDetailsService userDetailsService, FirebaseAuth firebaseAuth) {
        this.userDetailsService = userDetailsService;
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // get the token from the request
//        String requestURI = request.getRequestURI();
//
//        // '/users' 경로의 POST 요청은 인증을 건너뛴다.
//        if (requestURI.equals("/users") && request.getMethod().equals("POST")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        FirebaseToken decodedToken;
//
//        try{
//            String header = RequestUtil.getAuthorizationToken(request.getHeader("Authorization"));
//            decodedToken = firebaseAuth.verifyIdToken(header);
//        } catch (FirebaseAuthException | IllegalArgumentException e) {
//            // ErrorMessage 응답 전송
//            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//            response.getWriter().write("{\"code\":\"INVALID_TOKEN\", \"message\":\"" + e.getMessage() + "\"}");
//            return;
//        }
//
//        try {
//            UserDetails user = userDetailsService.loadUserByUsername(decodedToken.getUid());
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                    user, null, user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        } catch (UsernameNotFoundException e) {
//            // UsernameNotFoundException 처리
//            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//            response.getWriter().write("{\"code\":\"USER_NOT_FOUND\"}");
//            return;
//        } catch (NoSuchElementException e) {
//            // NoSuchElementException 처리
//            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//            response.getWriter().write("{\"code\":\"USER_NOT_FOUND\"}");
//            return;
//        }
        filterChain.doFilter(request, response);

    }
}