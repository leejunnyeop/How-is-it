package com.example.howIsIt.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class FirebaseUserDetails implements UserDetails {

    private final String username;


    // Constructor, Getters, and other methods

    public FirebaseUserDetails(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the user's authorities
        return null;
    }

    @Override
    public String getPassword() {
        // Firebase authentication does not use passwords
        return null;
    }

    @Override
    public String getUsername() {
        // Return the username (email or UID)
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
