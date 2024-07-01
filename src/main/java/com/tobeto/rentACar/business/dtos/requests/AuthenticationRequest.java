package com.tobeto.rentACar.business.dtos.requests;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;

}