package com.mitesh.SpringSecurity.Service;

import com.mitesh.SpringSecurity.DAO.UserRepo;
import com.mitesh.SpringSecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);



    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        //encoded password which we are registering
        System.out.println(user.getPassword());
        return repo.save(user);
    }
}
