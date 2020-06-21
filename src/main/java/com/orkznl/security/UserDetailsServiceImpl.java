package com.orkznl.security;

import com.orkznl.model.User;
import com.orkznl.model.UserRole;
import com.orkznl.repository.UserRepository;
import com.orkznl.repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

import static com.orkznl.security.SecurityConstants.*;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {

        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    /**
     * Retrieve an account depending on its login this method is not case sensitive.
     *
     * @param username the user's username
     * @return a Spring Security userdetails object that matches the username
     * @throws UsernameNotFoundException when the user could not be found
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) {

        if (username == null || username.trim().isEmpty()) {

            throw new UsernameNotFoundException("Empty username");
        }
        LOG.debug("Security verification for user '{}'", username);
        User user = userRepository.findByUsername(username);
        if (user == null) {

            LOG.info("User {} could not be found", username);
            throw new UsernameNotFoundException("user " + username + " could not be found");
        }

        Collection<GrantedAuthority> grantedAuthorities;
        Set<String> roles = new HashSet<>();

        List<UserRole> userRoles = userRoleRepository.findByUser(user);

        for (UserRole userRole : userRoles) {
            switch (userRole.getRole().getId().intValue()) {
                case 1:
                    roles.add(ROLE_ADMIN);
                    break;
                case 2:
                    roles.add(ROLE_SUPERUSER);
                    break;
                case 3: default:
                    roles.add(ROLE_USER);
                    break;
            }
        }

        grantedAuthorities = toGrantedAuthorities(roles);

        String password = user.getPassword();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new UserWithId(username, password, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities, user.getId());
    }

    private Collection<GrantedAuthority> toGrantedAuthorities(Set<String> roles) {

        List<GrantedAuthority> result = new ArrayList<>();
        for (String role : roles) {

            result.add(new SimpleGrantedAuthority(role));
        }
        return result;
    }
}