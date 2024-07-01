package com.tobeto.rentACar.business.rules;

import com.tobeto.rentACar.core.utilities.mapping.exception.types.BusinessException;
import com.tobeto.rentACar.dataAccess.abstracts.ModelRepository;
import com.tobeto.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    ModelRepository modelRepository;

    public void modelNameCanNotBeDuplicated(
            String modelName
    ){
        Optional<Model> model = modelRepository.findByNameIgnoreCase(modelName);
        if(model.isPresent()){
            throw new BusinessException("Model name already exist!");
        }
    }

}