package com.tobeto.rentACar.business.dtos.responses;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedModelResponse {
    private String name;
    private int brandId;
    private int fuelId;
    private int transmissionId;
}
