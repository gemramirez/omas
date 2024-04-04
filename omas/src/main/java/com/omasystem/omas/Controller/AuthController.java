package com.omasystem.omas.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.omasystem.omas.Entity.AuthenticationRequest;
import com.omasystem.omas.Entity.AuthenticationResponse;
import com.omasystem.omas.Entity.RegisterRequest;
import com.omasystem.omas.Service.AuthenticationService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthenticationService service;

    @PostMapping("/Register")
    public ResponseEntity<AuthenticationResponse> register (
        @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/Authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
        @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
    
}

