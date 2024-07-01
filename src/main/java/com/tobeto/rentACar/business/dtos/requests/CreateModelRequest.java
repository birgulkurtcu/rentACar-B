package com.tobeto.rentACar.business.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateModelRequest {
    private String name;
    private int brandId;
    private int fuelId;
    private int transmissionId;
    private String imageUrl;

}
