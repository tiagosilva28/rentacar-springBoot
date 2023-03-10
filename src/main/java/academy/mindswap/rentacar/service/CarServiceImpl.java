package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.CarConverter;
import academy.mindswap.rentacar.dto.CarCreateDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;
    CarConverter carConverter = new CarConverter();
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
    public CarDto createCar(CarCreateDto carCreateDto) {

        Car car = carConverter.fromCarCreateDtoToEntity(carCreateDto);
        car = carRepository.save(car);
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public CarDto getCarById(Long userId) {
        Car car = carRepository.getReferenceById(userId);
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDtos = cars.parallelStream()
                .map(carConverter::fromCarEntityToCarDto)
                .toList();
        return carDtos;
    }

    @Override
    public CarDto updateCar(Long id, CarDto carDto) {
        Car car = carRepository.getReferenceById(id);
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        carRepository.save(car);
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);

    }
}
