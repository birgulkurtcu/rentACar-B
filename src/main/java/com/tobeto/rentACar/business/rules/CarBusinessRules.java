package com.tobeto.rentACar.business.rules;

import com.tobeto.rentACar.core.utilities.mapping.exception.types.BusinessException;
import com.tobeto.rentACar.dataAccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    CarRepository carRepository;
    public void plateCanNotBeDuplicated(
            String plate
    ){
        boolean isPlateExist = carRepository.existsByPlate(plate);
        if(isPlateExist){
            throw new BusinessException("Plate already exist!");
        }
    }

}