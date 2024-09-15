package com.LoginSignup.loginAndSingUp.controller;

import com.LoginSignup.loginAndSingUp.entity.User;
import com.LoginSignup.loginAndSingUp.jwt.JwtUtil;
import com.LoginSignup.loginAndSingUp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/test")
    public String test() {
        return "local is live now:";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {
        try {
            User loggedInUser = userService.loginUser(user.getUserName(), user.getPassword());

            // Generate JWT token if credentials are correct
            String token = jwtUtil.generateToken(loggedInUser.getUserName());

            // Prepare the response data
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("message", "Login successful!");
            response.put("result", true);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            // If login fails, return an appropriate error response
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Invalid credentials");
            errorResponse.put("result", false);

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
