package com.nedyalkoboydev.autoserviceplatform.application.services;

import com.nedyalkoboydev.autoserviceplatform.application.configurations.JwtService;
import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IAuthenticationService;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.Client;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.Employee;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.User;
import com.nedyalkoboydev.autoserviceplatform.domain.enums.Role;
import com.nedyalkoboydev.autoserviceplatform.domain.models.AuthenticationResponse;
import com.nedyalkoboydev.autoserviceplatform.domain.models.LoginViewModel;
import com.nedyalkoboydev.autoserviceplatform.domain.models.RegisterViewModel;
import com.nedyalkoboydev.autoserviceplatform.persistence.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {
    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    @Override
    public AuthenticationResponse register(RegisterViewModel request) {
        User user = null;
        switch (request.getRole()){
            case ROLE_CLIENT:
                user = Client.builder()
                        .firstName(request.getFirstname())
                        .lastName(request.getLastname())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(request.getRole())
                        .phoneNumber(request.getPhoneNumber())
                        .build();
                break;
            case ROLE_EMPLOYEE:
                user = Employee.builder()
                        .firstName(request.getFirstname())
                        .lastName(request.getLastname())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(request.getRole())
                        .build();
                break;
        }

        repository.save(user);
        String jwtToken = jwtService.generateToken(Map.of("id", user.getId()), user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse login(LoginViewModel request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(Map.of("id", user.getId()), user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
