package com.tobeto.rentACar.business.concretes;

import com.tobeto.rentACar.business.abstracts.BrandService;
import com.tobeto.rentACar.business.dtos.requests.CreateBrandRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateBrandRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetBrandByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateBrandResponse;
import com.tobeto.rentACar.business.rules.BrandBusinessRules;
import com.tobeto.rentACar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentACar.dataAccess.abstracts.BrandRepository;
import com.tobeto.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public CreatedBrandResponse createBrand(
            CreateBrandRequest request
    ) {
        brandBusinessRules.brandNameCanNotBeDuplicated(request.getName());

        // TODO: Business rules.

        Brand brand = this.modelMapperService
                .forRequest()
                .map(request,Brand.class);

        brand.setCreatedDate(LocalDateTime.now());

        brandRepository.save(brand);

        CreatedBrandResponse response = this.modelMapperService
                .forResponse().map(brand, CreatedBrandResponse.class);

        return response;
    }

    @Override
    public List<GetAllBrandResponse> getAllBrands(

    ) {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> brandResponses =
                brands.stream().map(brand -> modelMapperService
                                .forResponse()
                                .map(brand, GetAllBrandResponse.class))
                        .collect(Collectors.toList());

        return brandResponses;
    }

    @Override
    public GetBrandByIdResponse getBrandById(
            int id
    ) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this ID."));

        GetBrandByIdResponse response = modelMapperService.forResponse()
                .map(brand, GetBrandByIdResponse.class);

        return response;
    }

    @Override
    public UpdateBrandResponse updateBrandById(
            UpdateBrandRequest request,
            int id
    ) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this ID."));

        Brand updatedBrand = modelMapperService.forRequest()
                .map(request,Brand.class);

        brand.setId(id);
        brand.setUpdatedDate(LocalDateTime.now());


        brand.setName(updatedBrand.getName() != null ? updatedBrand.getName() : brand.getName());

        brandRepository.save(brand);

        UpdateBrandResponse response = modelMapperService.forResponse()
                .map(brand, UpdateBrandResponse.class);

        return response;

    }
    @Override
    public void deleteBrandById(
            int id
    ) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this ID."));

        brand.setDeletedDate(LocalDateTime.now());
        brandRepository.deleteById(id);
    }
}