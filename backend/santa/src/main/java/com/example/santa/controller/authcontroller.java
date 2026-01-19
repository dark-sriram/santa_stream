package com.example.santa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.santa.dto.Loginrequest;
import com.example.santa.dto.Registerrequest;
import com.example.santa.service.Authservice;

@RestController
@RequestMapping("/api/auth")
public class authcontroller {

    @Autowired
    private Authservice authService;

    @PostMapping("/register")
    public String register(@RequestBody Registerrequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody Loginrequest request) {
        return authService.login(request);
    }
}
