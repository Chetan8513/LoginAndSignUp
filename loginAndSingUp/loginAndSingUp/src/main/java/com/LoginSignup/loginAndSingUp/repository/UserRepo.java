package com.LoginSignup.loginAndSingUp.repository;


import com.LoginSignup.loginAndSingUp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

 User findByUserName(String userName);

}
