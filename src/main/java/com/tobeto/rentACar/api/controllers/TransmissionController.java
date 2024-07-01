package com.tobeto.rentACar.api.controllers;

import com.tobeto.rentACar.business.abstracts.FuelService;
import com.tobeto.rentACar.business.abstracts.ModelService;
import com.tobeto.rentACar.business.abstracts.TransmissionService;
import com.tobeto.rentACar.business.dtos.requests.CreateFuelRequest;
import com.tobeto.rentACar.business.dtos.requests.CreateModelRequest;
import com.tobeto.rentACar.business.dtos.requests.CreateTransmissionRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateTransmissionRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedTransmissionResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllTransmissionResponse;
import com.tobeto.rentACar.business.dtos.responses.GetTransmissionByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateTransmissionResponse;
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
@RequestMapping("api/v1/trasmissions")
public class TransmissionController {
    private TransmissionService transmissionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionResponse createTransmission(
            @RequestBody CreateTransmissionRequest request
    ){
        return transmissionService.createTransmission(request);
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTransmissionResponse> getAllTransmissions(

    ){
        return transmissionService.getAllTransmissions();
    }

    @GetMapping("/{id}")
    public GetTransmissionByIdResponse getTransmissionById(
            @PathVariable int id
    ) {
        return transmissionService.getTransmissionById(id);
    }

    @PutMapping("/{id}")
    public UpdateTransmissionResponse updateTransmissionById(
            @RequestBody UpdateTransmissionRequest request,
            @PathVariable int id
    ) {
        return transmissionService.updateTransmissionById(request,id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTransmissionById(@PathVariable int id) {
        transmissionService.deleteTransmissionById(id);
    }

}