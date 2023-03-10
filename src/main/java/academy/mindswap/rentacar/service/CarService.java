package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.CarCreateDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;

import java.util.List;

public interface CarService {
   // Car getCars();

    CarDto createCar(CarCreateDto car);

    CarDto getCarById(Long userId);

    List<CarDto> getAllCars();

    CarDto updateCar(Long id, CarDto car);

    void deleteCar(Long userId);
}
