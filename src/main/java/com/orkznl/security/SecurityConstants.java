package com.orkznl.security;

public class SecurityConstants {

    public static final String SECRET = "ThisIsOrkzSuperSecretKey";
    public static final long EXPIRATION_TIME = 4 * 60 * 60 * 1000; // 4 hours

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_SUPERUSER = "ROLE_SUPERUSER";
    public static final String ROLE_USER = "ROLE_USER";
}