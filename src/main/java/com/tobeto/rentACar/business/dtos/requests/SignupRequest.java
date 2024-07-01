package com.tobeto.rentACar.business.dtos.requests;

import lombok.Data;

@Data
public class SignupRequest {

    private String email;

    private String name;

    private String password;


}