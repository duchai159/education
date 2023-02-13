package com.dhai.education.dto;

import lombok.Data;

@Data

public class RegistrationRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
