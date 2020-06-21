package com.orkznl.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orkznl.model.User;
import com.orkznl.model.UserRole;
import com.orkznl.repository.UserRepository;
import com.orkznl.repository.UserRoleRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.orkznl.security.SecurityConstants.*;

@Component
public class TokenAuthenticationService {

    @Autowired private UserRepository userRepository;
    @Autowired private UserRoleRepository userRoleRepository;

    @Transactional
    public void addAuthentication(HttpServletResponse res, String username) throws JsonProcessingException {

        User user = userRepository.findByUsername(username);

        List<UserRole> userRoles = userRoleRepository.findByUser(user);

        List<String> roles = new ArrayList<>();
        for(UserRole userRole: userRoles) {
            switch (userRole.getRole().getId().intValue()) {
                case 1:
                    roles.add(ROLE_ADMIN);
                    break;
                case 2:
                    roles.add(ROLE_SUPERUSER);
                    break;
                case 3:
                default:
                    roles.add(ROLE_USER);
                    break;
            }
        }

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("roles", roles);

        String accessToken = SecurityConstants.TOKEN_PREFIX + Jwts.builder().setClaims(claims).setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET).compact();

        Date refreshTokenExp = new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME * 2);

        String refreshToken = SecurityConstants.TOKEN_PREFIX + Jwts.builder()
                .setClaims(claims).setSubject(username)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(refreshTokenExp)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("accessToken", accessToken);
        tokenMap.put("refreshToken", refreshToken);

        String auth = new ObjectMapper().writeValueAsString(tokenMap);

        res.setHeader(SecurityConstants.HEADER_STRING, auth);
    }

    static Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {

        AuthenticationToken authenticationToken = null;

        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        if (token != null) {

            Claims claims = (Jwts.parser().setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody());

            List<String> roles = claims.get("roles", List.class);
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles.toArray(new String[roles.size()]));

            if (claims.getSubject() != null) {
                authenticationToken = new AuthenticationToken(claims.getSubject(), null, authorities,
                        claims.get("userId", Integer.class));
            }
        }

        return authenticationToken;
    }

}