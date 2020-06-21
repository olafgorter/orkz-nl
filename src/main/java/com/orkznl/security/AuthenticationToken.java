package com.orkznl.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 1L;

    private final Integer userId;

    public AuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,
                               Integer userId) {

        super(principal, credentials, authorities);
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
