package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;

import java.util.List;

public interface CarService {
   // Car getCars();

    Car createCar(Car car);

    Car getCarById(Long userId);

    List<Car> getAllCars();

    Car updateCar(Car car);

    void deleteCar(Long userId);
}
