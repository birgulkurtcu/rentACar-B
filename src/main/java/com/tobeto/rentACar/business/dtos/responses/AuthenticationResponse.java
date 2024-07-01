package com.tobeto.rentACar.business.dtos.responses;

import com.tobeto.rentACar.entities.concretes.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;

}