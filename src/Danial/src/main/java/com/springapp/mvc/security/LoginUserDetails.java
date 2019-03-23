package com.springapp.mvc.security;

/**
 * Created by john on 7/2/14.
 */


import com.springapp.mvc.domain.AuthenticationEntity;
import com.springapp.mvc.service.AuthenticationService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

public class LoginUserDetails implements UserDetailsService {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        final AuthenticationEntity user= authenticationService.getUserDetails(username);
        if (user==null) {
            throw new UsernameNotFoundException(username + " not found");
        }
        //creating dummy user details, should do JDBC operations
        return new UserDetails() {

            private static final long serialVersionUID = 2059202961588104658L;

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            //To DO for authentication.
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();

               if(user.getRoleId()==1) {
                    auths.add(new SimpleGrantedAuthority("admin"));
                }
                else if(user.getRoleId()==2) {
                    auths.add(new SimpleGrantedAuthority("user"));
                }

                return auths;
            }
        };
    }

}