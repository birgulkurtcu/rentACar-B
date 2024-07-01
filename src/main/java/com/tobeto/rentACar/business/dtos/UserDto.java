package com.tobeto.rentACar.business.dtos;

import com.tobeto.rentACar.entities.concretes.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userrole;
}

