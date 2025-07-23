package com.cognizant.spring_learn_REST.auth_jwt.controller;


import com.cognizant.spring_learn_REST.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public ResponseEntity<?> generateToken(@RequestHeader("Authorization") String authHeader) {
        // Basic dXNlcjpwd2Q= (base64 of user:pwd)
        if (!authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Missing Basic Authentication Header");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded);
        String[] values = credentials.split(":", 2);

        String username = values[0];
        String password = values[1];

        // Simple check (replace with database or user service)
        if ("user".equals(username) && "pwd".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok().body("{\"token\":\"" + token + "\"}");
        } else {
            return ResponseEntity.status(403).body("Invalid credentials");
        }
    }
}
