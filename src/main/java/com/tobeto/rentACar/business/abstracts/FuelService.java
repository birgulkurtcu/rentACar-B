package com.tobeto.rentACar.business.abstracts;
import com.tobeto.rentACar.business.dtos.requests.CreateFuelRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateFuelRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedFuelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllFuelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetFuelByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateFuelResponse;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse createFuel(
            CreateFuelRequest request
    );
    List<GetAllFuelResponse> getAllFuels(
    );
    GetFuelByIdResponse getFuelById(
            int id
    );
    UpdateFuelResponse updateFuelById(
            UpdateFuelRequest request,
            int id
    );

    void deleteFuelById(
            int id
    );
}