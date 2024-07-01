package com.tobeto.rentACar.business.abstracts;

import com.tobeto.rentACar.business.dtos.requests.CreateBrandRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateBrandRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetBrandByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse createBrand(
            CreateBrandRequest request
    );
    List<GetAllBrandResponse> getAllBrands(

    );
    GetBrandByIdResponse getBrandById(
            int id
    );
    UpdateBrandResponse updateBrandById(
            UpdateBrandRequest request,
            int id
    );
    void deleteBrandById(
            int id
    );

}