package com.tobeto.rentACar.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateFuelRequest {
    private int fuelId;
    private String name;
}
