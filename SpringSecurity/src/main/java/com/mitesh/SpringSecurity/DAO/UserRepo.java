package com.mitesh.SpringSecurity.DAO;

import com.mitesh.SpringSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);

}
