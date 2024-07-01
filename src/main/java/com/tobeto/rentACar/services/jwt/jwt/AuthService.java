package com.tobeto.rentACar.services.jwt.jwt;

import com.tobeto.rentACar.business.dtos.UserDto;
import com.tobeto.rentACar.business.dtos.requests.SignupRequest;

public interface AuthService {
    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
