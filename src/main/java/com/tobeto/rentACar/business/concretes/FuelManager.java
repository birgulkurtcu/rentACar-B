package com.tobeto.rentACar.business.concretes;

import com.tobeto.rentACar.business.abstracts.FuelService;
import com.tobeto.rentACar.business.dtos.requests.CreateFuelRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateFuelRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedFuelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllFuelResponse;
import com.tobeto.rentACar.business.dtos.responses.GetFuelByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateFuelResponse;
import com.tobeto.rentACar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentACar.dataAccess.abstracts.FuelRepository;
import com.tobeto.rentACar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedFuelResponse createFuel(
            CreateFuelRequest request
    ) {
        Fuel fuel = this.modelMapperService
                .forRequest()
                .map(request,Fuel.class);

        fuel.setCreatedDate(LocalDateTime.now());

        fuelRepository.save(fuel);

        CreatedFuelResponse response = this.modelMapperService
                .forResponse().map(fuel, CreatedFuelResponse.class);

        return response;
    }

    @Override
    public List<GetAllFuelResponse> getAllFuels(

    ) {
        List<Fuel> fuels = fuelRepository.findAll();

        List<GetAllFuelResponse> fuelResponses =
                fuels.stream().map(fuel -> modelMapperService
                                .forResponse()
                                .map(fuel, GetAllFuelResponse.class))
                        .collect(Collectors.toList());

        return fuelResponses;
    }

    @Override
    public GetFuelByIdResponse getFuelById(
            int id
    ) {
        Fuel fuel = fuelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no fuel for this ID."));

        GetFuelByIdResponse response = modelMapperService.forResponse()
                .map(fuel, GetFuelByIdResponse.class);

        return response;
    }

    @Override
    public UpdateFuelResponse updateFuelById(
            UpdateFuelRequest request,
            int id
    ) {
        Fuel fuel = fuelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no fuel for this ID."));

        Fuel updatedFuel = modelMapperService.forRequest()
                .map(request,Fuel.class);

        fuel.setId(id);
        fuel.setUpdatedDate(LocalDateTime.now());

        fuel.setName(updatedFuel.getName());

        fuelRepository.save(fuel);

        UpdateFuelResponse response = modelMapperService.forResponse()
                .map(fuel,UpdateFuelResponse.class);

        return response;
    }

    @Override
    public void deleteFuelById(
            int id
    ) {
        Fuel fuel = fuelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no fuel for this id."));

        fuel.setDeletedDate(LocalDateTime.now());

        fuelRepository.deleteById(id);
    }

}