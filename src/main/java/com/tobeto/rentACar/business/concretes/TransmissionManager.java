package com.tobeto.rentACar.business.concretes;

import com.tobeto.rentACar.business.abstracts.TransmissionService;
import com.tobeto.rentACar.business.dtos.requests.CreateTransmissionRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateTransmissionRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedTransmissionResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllTransmissionResponse;
import com.tobeto.rentACar.business.dtos.responses.GetTransmissionByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateTransmissionResponse;
import com.tobeto.rentACar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentACar.dataAccess.abstracts.TransmissionRepository;
import com.tobeto.rentACar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedTransmissionResponse createTransmission(
            CreateTransmissionRequest request
    ) {
        Transmission transmission = this.modelMapperService
                .forRequest()
                .map(request,Transmission.class);

        transmission.setCreatedDate(LocalDateTime.now());

        transmissionRepository.save(transmission);

        CreatedTransmissionResponse response = this.modelMapperService
                .forResponse().map(transmission, CreatedTransmissionResponse.class);

        return response;
    }

    @Override
    public List<GetAllTransmissionResponse> getAllTransmissions(

    ) {
        List<Transmission> transmissions = transmissionRepository.findAll();

        List<GetAllTransmissionResponse> transmissionResponses =
                transmissions.stream().map(transmission -> modelMapperService
                                .forResponse()
                                .map(transmission, GetAllTransmissionResponse.class))
                        .collect(Collectors.toList());

        return transmissionResponses;
    }

    @Override
    public GetTransmissionByIdResponse getTransmissionById(
            int id
    ) {
        Transmission transmission = transmissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no transmission for this ID."));

        GetTransmissionByIdResponse response = modelMapperService.forResponse()
                .map(transmission, GetTransmissionByIdResponse.class);

        return response;
    }

    @Override
    public UpdateTransmissionResponse updateTransmissionById(
            UpdateTransmissionRequest request,
            int id
    ) {
        Transmission transmission = transmissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no transmission for this ID."));

        Transmission updatedTransmission = modelMapperService.forRequest()
                .map(request,Transmission.class);

        transmission.setId(id);
        transmission.setUpdatedDate(LocalDateTime.now());

        transmission.setName(updatedTransmission.getName());

        transmissionRepository.save(transmission);

        UpdateTransmissionResponse response = modelMapperService.forResponse()
                .map(transmission, UpdateTransmissionResponse.class);

        return response;
    }
        @Override
        public void deleteTransmissionById(
                int id
        ) {
            Transmission transmission = transmissionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("There is no transsmission for this id."));

            transmission.setDeletedDate(LocalDateTime.now());

            transmissionRepository.deleteById(id);
        }

}