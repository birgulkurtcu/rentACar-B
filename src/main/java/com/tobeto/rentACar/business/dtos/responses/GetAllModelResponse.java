package com.tobeto.rentACar.business.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelResponse {

    private int id;
    private String name;
    private int brandId;
    private int fuelId;
    private int transmissionId;
    private String imageUrl;
}
