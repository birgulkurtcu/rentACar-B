package com.tobeto.rentACar.api.controllers;


import com.tobeto.rentACar.business.abstracts.ModelService;
import com.tobeto.rentACar.business.dtos.requests.CreateModelRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateModelRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedModelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllModelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetModelByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateModelResponse;
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
@RequestMapping("api/v1/models")
public class ModelController {
    private ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse createModel(
            @Valid @RequestBody CreateModelRequest request
    ){
        return modelService.createModel(request);
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllModelResponse> getAllModels(

    ){
        return modelService.getAllModels();
    }
    @GetMapping("/{id}")
    public GetModelByIdResponse getModelById(
            @PathVariable int id
    ){
        return modelService.getModelById(id);
    }
    @PutMapping("/{id}")
    public UpdateModelResponse updateModelById(
            @RequestBody UpdateModelRequest request,
            @PathVariable int id
    ) {
        return modelService.updateModelById(request,id);
    }
    @DeleteMapping(value = "delete/{id}" , produces = MediaType. APPLICATION_JSON_VALUE)
    public void deleteModelById(
            @PathVariable int id
    ){
        modelService.deleteModelById(id);
    }
}