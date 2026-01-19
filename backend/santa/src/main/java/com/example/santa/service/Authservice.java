package com.example.santa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.santa.dto.Loginrequest;
import com.example.santa.dto.Registerrequest;
import com.example.santa.entity.UserEntity;
import com.example.santa.repository.Userrepository;
import com.example.santa.security.Jwtutil;

@Service
public class Authservice {
    private static final Logger logger = LogManager.getLogger(Authservice.class);

    @Autowired
    private Userrepository userRepository;

    @Autowired
    private Jwtutil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(Registerrequest request) {
        logger.info("Registering user {}", request.getEmail());

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : "USER");


        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(Loginrequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        logger.info("User logged in {}", request.getEmail());
        return jwtUtil.generateToken(user.getEmail());
    }
}
