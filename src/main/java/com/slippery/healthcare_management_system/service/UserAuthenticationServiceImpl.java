package com.slippery.healthcare_management_system.service;

import com.slippery.healthcare_management_system.model.User;
import com.slippery.healthcare_management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService{
    private final UserRepository repository;

    public UserAuthenticationServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
