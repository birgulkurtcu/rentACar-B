package com.tobeto.rentACar.business.abstracts;

import com.tobeto.rentACar.business.dtos.requests.CreateModelRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateModelRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedModelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllModelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetModelByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    CreatedModelResponse createModel(
            CreateModelRequest request
    );
    List<GetAllModelResponse> getAllModels(

    );
    GetModelByIdResponse getModelById(
            int id
    );
    UpdateModelResponse updateModelById(
            UpdateModelRequest request,
            int id
    );
    void deleteModelById(
            int id
    );
}