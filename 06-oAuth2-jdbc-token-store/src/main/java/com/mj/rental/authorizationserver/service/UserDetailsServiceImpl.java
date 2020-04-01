package com.mj.rental.authorizationserver.service;

import com.mj.rental.authorizationserver.model.AuthUserDetail;
import com.mj.rental.authorizationserver.model.User;
import com.mj.rental.authorizationserver.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User optionalUser=userDetailsRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Username or pasword incorrect"));

        UserDetails userDetails=new AuthUserDetail(optionalUser);
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
