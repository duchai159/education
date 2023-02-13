package com.dhai.education.service.impl;

import com.dhai.education.dto.LoginRequest;
import com.dhai.education.dto.RegistrationRequest;
import com.dhai.education.entity.User;
import com.dhai.education.repository.RoleRepository;
import com.dhai.education.repository.UserRepository;
import com.dhai.education.security.jwt.JwtUtils;
import com.dhai.education.service.AuthService;
import com.dhai.education.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public ResponseEntity<?> register(RegistrationRequest registrationRequest) {
        User user = User.builder()
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .phone(registrationRequest.getPhone())
                .roles(List.of(roleService.getByName("ROLE_STUDENT")))
                .build();
        userRepository.save(user);
        return ResponseEntity.ok("Successfully");
    }

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok(jwt);
    }
}
