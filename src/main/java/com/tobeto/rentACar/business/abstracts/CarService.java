package com.tobeto.rentACar.business.abstracts;

import com.tobeto.rentACar.business.dtos.requests.CreateBrandRequest;
import com.tobeto.rentACar.business.dtos.requests.CreateCarRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateCarRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.CreatedCarResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllCarResponse;
import com.tobeto.rentACar.business.dtos.responses.GetCarByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateCarResponse;

import java.util.List;

public interface CarService {
    CreatedCarResponse createCar(
            CreateCarRequest request
    );
    List<GetAllCarResponse> getAllCars(

    );
    GetCarByIdResponse getCarById(
            int id
    );
    UpdateCarResponse updateCarById(
            UpdateCarRequest request,
            int id
    );
    void deleteCarById(
            int id
    );
}