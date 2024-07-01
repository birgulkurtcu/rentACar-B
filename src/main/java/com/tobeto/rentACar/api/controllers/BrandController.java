package com.tobeto.rentACar.api.controllers;

import com.tobeto.rentACar.business.abstracts.BrandService;
import com.tobeto.rentACar.business.dtos.requests.CreateBrandRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateBrandRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetBrandByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateBrandResponse;
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
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandController {
    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse createBrand(
            @Valid @RequestBody CreateBrandRequest request
    ) {
        return brandService.createBrand(request);
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAllBrands(

    ) {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public GetBrandByIdResponse getBrandById(
            @PathVariable int id
    ) {
        return brandService.getBrandById(id);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse updateBrandById(
            @RequestBody UpdateBrandRequest request,
            @PathVariable int id
    ) {
        return brandService.updateBrandById(request, id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBrandById(@PathVariable int id) {
        brandService.deleteBrandById(id);
    }
}
