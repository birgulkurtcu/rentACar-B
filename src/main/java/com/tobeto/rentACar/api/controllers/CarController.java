package com.tobeto.rentACar.api.controllers;

import com.tobeto.rentACar.business.abstracts.BrandService;
import com.tobeto.rentACar.business.abstracts.CarService;
import com.tobeto.rentACar.business.dtos.requests.CreateBrandRequest;
import com.tobeto.rentACar.business.dtos.requests.CreateCarRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateCarRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.CreatedCarResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllCarResponse;
import com.tobeto.rentACar.business.dtos.responses.GetCarByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarController {
    private CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse createCar(
            @RequestBody @Valid CreateCarRequest request
    ){
        return carService.createCar(request);
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCarResponse> getAllCars(

    ){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public GetCarByIdResponse getCarById(
            @PathVariable int id
    ){
        return carService.getCarById(id);
    }

    @PutMapping("/{id}")
    public UpdateCarResponse updateCarById(
            @RequestBody UpdateCarRequest request,
            @PathVariable int id
    ){
        return carService.updateCarById(request,id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCarById(@PathVariable int id){
        carService.deleteCarById(id);
    }
}