package org.example.authservice.Service;

import org.example.authservice.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrinciple implements UserDetails {
    private final User User;
    public UserPrinciple(User User) {
        this.User = User;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(User.getRole());
        return Collections.singleton(new SimpleGrantedAuthority(User.getRole()));
    }

    @Override
    public String getPassword() {
        return User.getPassword();
    }

    @Override
    public String getUsername() {
        return User.getEmail();
    }
}

