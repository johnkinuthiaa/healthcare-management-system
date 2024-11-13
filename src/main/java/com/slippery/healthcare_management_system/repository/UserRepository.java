package com.slippery.healthcare_management_system.repository;

import com.slippery.healthcare_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
