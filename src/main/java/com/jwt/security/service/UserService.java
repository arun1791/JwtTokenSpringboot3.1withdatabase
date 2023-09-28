package com.jwt.security.service;

import com.jwt.security.entities.User;
import com.jwt.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


//    private List<User> store=new ArrayList<User>();

//    public  UserService() {
//        store.add(new User(UUID.randomUUID().toString(), "admin", "admin@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(), "user", "user@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(), "arun", "arun@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(), "neha", "neha@gmail.com"));
//    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public User createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

}
