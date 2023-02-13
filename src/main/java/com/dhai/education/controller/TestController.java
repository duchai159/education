package com.dhai.education.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    ResponseEntity<?> hello() {
        return ResponseEntity.ok("hello");
    }
    @GetMapping("/hi")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    ResponseEntity<?> hi(){
        return ResponseEntity.ok("hi");
    }
}
