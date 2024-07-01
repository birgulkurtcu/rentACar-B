package com.tobeto.rentACar.business.concretes;

import com.tobeto.rentACar.business.abstracts.BrandService;
import com.tobeto.rentACar.business.abstracts.CarService;
import com.tobeto.rentACar.business.dtos.requests.CreateBrandRequest;
import com.tobeto.rentACar.business.dtos.requests.CreateCarRequest;
import com.tobeto.rentACar.business.dtos.requests.UpdateCarRequest;
import com.tobeto.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.CreatedCarResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllBrandResponse;
import com.tobeto.rentACar.business.dtos.responses.GetAllCarResponse;
import com.tobeto.rentACar.business.dtos.responses.GetCarByIdResponse;
import com.tobeto.rentACar.business.dtos.responses.UpdateCarResponse;
import com.tobeto.rentACar.business.rules.CarBusinessRules;
import com.tobeto.rentACar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentACar.dataAccess.abstracts.BrandRepository;
import com.tobeto.rentACar.dataAccess.abstracts.CarRepository;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;


    @Override
    public CreatedCarResponse createCar(
            CreateCarRequest request
    ) {
        carBusinessRules.plateCanNotBeDuplicated(request.getPlate());

        Car car = this.modelMapperService
                .forRequest()
                .map(request,Car.class);

        car.setCreatedDate(LocalDateTime.now());
        carRepository.save(car);

        CreatedCarResponse response = this.modelMapperService
                .forResponse().map(car, CreatedCarResponse.class);

        return response;
    }

    @Override
    public List<GetAllCarResponse> getAllCars(

    ) {
        List<Car> cars = carRepository.findAll();

        List<GetAllCarResponse> carResponses =
                cars.stream().map(car -> modelMapperService
                                .forResponse()
                                .map(car, GetAllCarResponse.class))
                        .collect(Collectors.toList());

        return carResponses;
    }

    @Override
    public GetCarByIdResponse getCarById(
            int id
    ) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There no car for this ID."));

        GetCarByIdResponse response = modelMapperService.forResponse()
                .map(car, GetCarByIdResponse.class);

        return response;
    }

    @Override
    public UpdateCarResponse updateCarById(
            UpdateCarRequest request,
            int id
    ) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no car for this ID."));

        Car updatedCar = modelMapperService.forRequest()
                .map(request,Car.class);

        car.setId(id);
        car.setUpdatedDate(LocalDateTime.now());

        car.setPlate(updatedCar.getPlate());
        car.setState(updatedCar.getState());
        car.setDailyPrice(updatedCar.getDailyPrice());

        carRepository.save(car);

        UpdateCarResponse response = modelMapperService.forResponse()
                .map(car,UpdateCarResponse.class);

        return response;

    }

    @Override
    public void deleteCarById(
            int id
    ) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no car for this ID."));
        car.setDeletedDate(LocalDateTime.now());
        carRepository.deleteById(id);
    }
}