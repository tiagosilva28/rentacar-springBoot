package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;
    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    /* @Override
    public Car getCars() {
        return Car.builder()
                .id(1L)
                .brand("Mini")
                .model("Clubman")
                .build();
    }

    */

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long userId) {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }

    @Override
    public void deleteCar(Long userId) {

    }
}
