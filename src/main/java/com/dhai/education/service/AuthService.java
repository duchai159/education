package com.dhai.education.service;

import com.dhai.education.dto.LoginRequest;
import com.dhai.education.dto.RegistrationRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> register(RegistrationRequest registrationRequest);
    ResponseEntity<?> login(LoginRequest loginRequest);
}
