package com.LoginSignup.loginAndSingUp.service;


import com.LoginSignup.loginAndSingUp.entity.User;
import com.LoginSignup.loginAndSingUp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }


    public User loginUser (String userName, String password){

        User user = userRepo.findByUserName(userName);
        if(user!=null && passwordEncoder.matches(password,user.getPassword())) {
            return user;
        }

        throw  new RuntimeException("Invalid Credentials");
    }

}
