package com.tobeto.rentACar.business.rules;

import com.tobeto.rentACar.core.utilities.mapping.exception.types.BusinessException;
import com.tobeto.rentACar.dataAccess.abstracts.BrandRepository;
import com.tobeto.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

    BrandRepository brandRepository;

    public void brandNameCanNotBeDuplicated(String brandName){
       Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
       if(brand.isPresent()){
           throw new BusinessException("BrandExists");
       }
    }
}
