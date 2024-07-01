package com.tobeto.rentACar.api.controllers;


import com.tobeto.rentACar.business.abstracts.FuelService;
import com.tobeto.rentACar.business.dtos.requests.CreateFuelRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateFuelRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedFuelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllFuelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetFuelByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateFuelResponse;
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
@RequestMapping("api/v1/fuels")
public class FuelController {
    private FuelService fuelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedFuelResponse createFuel(
            @Valid @RequestBody CreateFuelRequest request
    ){
        return fuelService.createFuel(request);
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllFuelResponse> getAllFuels(

    ){
        return fuelService.getAllFuels();
    }

    @GetMapping("/{id}")
    public GetFuelByIdResponse getFuelById(
            @PathVariable int id
    ){
        return fuelService.getFuelById(id);
    }
    @PutMapping("/{id}")
    public UpdateFuelResponse updateFuelById(
            @RequestBody UpdateFuelRequest request,
            @PathVariable int id
    ){
        return fuelService.updateFuelById(request,id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFuelById(@PathVariable int id) {
        fuelService.deleteFuelById(id);
    }
}