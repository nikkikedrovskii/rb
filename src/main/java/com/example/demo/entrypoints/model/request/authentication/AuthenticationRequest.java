package com.example.demo.entrypoints.model.request.authentication;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;

}
