package com.tobeto.rentACar.business.concretes;

import com.tobeto.rentACar.business.abstracts.ModelService;
import com.tobeto.rentACar.business.dtos.requests.CreateModelRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateModelRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedModelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllModelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetModelByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateModelResponse;
import com.tobeto.rentACar.business.rules.ModelBusinessRules;
import com.tobeto.rentACar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentACar.dataAccess.abstracts.ModelRepository;
import com.tobeto.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;

    @Override
    public CreatedModelResponse createModel(
            CreateModelRequest request
    ) {
        modelBusinessRules.modelNameCanNotBeDuplicated(request.getName());


        Model model = this.modelMapperService
                .forRequest()
                .map(request,Model.class);

        model.setId(0);
        model.setCreatedDate(LocalDateTime.now());

        this.modelRepository.save(model);

        CreatedModelResponse response = this.modelMapperService
                .forResponse().map(model, CreatedModelResponse.class);

        return response;

    }

    @Override
    public List<GetAllModelResponse> getAllModels(

    ) {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelResponse> modelResponses =
                models.stream().map(model -> modelMapperService
                                .forResponse()
                                .map(model, GetAllModelResponse.class))
                        .collect(Collectors.toList());

        return modelResponses;
    }

    @Override
    public GetModelByIdResponse getModelById(
            int id
    ) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for this ID."));

        GetModelByIdResponse response = modelMapperService.forResponse()
                .map(model, GetModelByIdResponse.class);

        return  response;
    }

    @Override
    public UpdateModelResponse updateModelById(
            UpdateModelRequest request,
            int id
    ) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for this id."));

        Model updatedModel = modelMapperService.forRequest()
                .map(request,Model.class);

        model.setId(id);
        model.setCreatedDate(LocalDateTime.now());
        model.setImageUrl(request.getImageUrl());

        model.setName(updatedModel.getName() != null ? updatedModel.getName() : model.getName());

        modelRepository.save(model);

        UpdateModelResponse response = modelMapperService.forResponse()
                .map(model,UpdateModelResponse.class);

        return response;

    }

    @Override
    public void deleteModelById(
            int id
    ) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for this id."));

        model.setDeletedDate(LocalDateTime.now());

        modelRepository.deleteById(id);
    }
}