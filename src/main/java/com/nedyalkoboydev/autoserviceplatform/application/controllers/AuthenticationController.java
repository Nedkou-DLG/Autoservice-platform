package com.nedyalkoboydev.autoserviceplatform.application.controllers;

import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IAuthenticationService;
import com.nedyalkoboydev.autoserviceplatform.domain.models.AuthenticationResponse;
import com.nedyalkoboydev.autoserviceplatform.domain.models.LoginViewModel;
import com.nedyalkoboydev.autoserviceplatform.domain.models.RegisterViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterViewModel request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginViewModel request){
        return ResponseEntity.ok(service.login(request));
    }
}
