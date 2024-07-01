package com.tobeto.rentACar.business.abstracts;

import com.tobeto.rentACar.business.dtos.requests.CreateModelRequest;
import com.tobeto.rentACar.business.dtos.requests.CreateTransmissionRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateTransmissionRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedModelResponse;
import com.tobeto.rentACar.business.dtos.responses.CreatedTransmissionResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllModelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllTransmissionResponse;
import com.tobeto.rentACar.business.dtos.responses.GetTransmissionByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateTransmissionResponse;

import java.util.List;

public interface TransmissionService {

    CreatedTransmissionResponse createTransmission(
            CreateTransmissionRequest request
    );

    List<GetAllTransmissionResponse> getAllTransmissions(

    );
    GetTransmissionByIdResponse getTransmissionById(
            int id
    );
    UpdateTransmissionResponse updateTransmissionById(
            UpdateTransmissionRequest request,
            int id
    );


    void deleteTransmissionById(int id);
}