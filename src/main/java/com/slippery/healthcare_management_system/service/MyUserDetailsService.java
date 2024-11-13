package com.slippery.healthcare_management_system.service;

import com.slippery.healthcare_management_system.model.User;
import com.slippery.healthcare_management_system.model.UserPrincipal;
import com.slippery.healthcare_management_system.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public MyUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if(user ==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}
