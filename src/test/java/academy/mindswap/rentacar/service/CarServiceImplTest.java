package academy.mindswap.rentacar.service;


import academy.mindswap.rentacar.converter.CarConverter;
import academy.mindswap.rentacar.dto.CarCreateDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarConverter carConverter;

    @Mock
    private CarRepository carRepository;

    @Test
    public void given_carDto_when_createCar_then_carCreated() {
        // Given
        CarCreateDto carCreateDto = new CarCreateDto();
        carCreateDto.setBrand("ANY_BRAND");
        carCreateDto.setModel("ANY_MODEL");

        Car expectedCar = new Car();
        expectedCar.setBrand(carCreateDto.getBrand());
        expectedCar.setModel(carCreateDto.getModel());

        CarDto expectedCarDto = new CarDto();
        expectedCarDto.setModel(expectedCar.getModel());
        expectedCarDto.setBrand(expectedCar.getBrand());

        given(carConverter.fromCarCreateDtoToEntity(carCreateDto)).willReturn(expectedCar);
        given(carRepository.save(expectedCar)).willReturn(expectedCar);
        given(carConverter.fromCarEntityToCarDto(expectedCar)).willReturn(expectedCarDto);

        // When
        CarDto result = carService.createCar(carCreateDto);

        // Then
        assertEquals(expectedCarDto, result);

        then(carConverter).should().fromCarCreateDtoToEntity(carCreateDto);
        then(carRepository).should().save(expectedCar);
        then(carConverter).should().fromCarEntityToCarDto(expectedCar);
    }

    @Test
    public void given_carId_when_getCarById_then_carDto() {
        // Given
        Car expectedCar = new Car();
        expectedCar.setId(6L);
        CarDto expectedCarDto = new CarDto();
        expectedCarDto.setModel("ANY_MODEL");
        expectedCarDto.setBrand("ANY_BRAND");

        given(carRepository.existsById(6L)).willReturn(true);
        given(carRepository.getReferenceById(6L)).willReturn(expectedCar);
        given(carConverter.fromCarEntityToCarDto(expectedCar)).willReturn(expectedCarDto);

        //When
        CarDto result = carService.getCarById(6L);

        // Then
        assertEquals(expectedCarDto, result);
    }


    @Test
    public void when_getAllCars_then_ListCarDto(){

        //Given
        Car car1 = new Car();
        car1.setBrand("ANY_BRAND");
        Car car2 = new Car();
        car2.setModel("ANY_MODEL");
        List<Car> cars = List.of(car1,car2);

        CarDto carDto1 = new CarDto();
        carDto1.setBrand(car1.getBrand());
        CarDto carDto2 = new CarDto();
        carDto2.setModel(car2.getModel());

        given(carRepository.findAll()).willReturn(cars);
        given(carConverter.fromCarEntityToCarDto(car1)).willReturn(carDto1);
        given(carConverter.fromCarEntityToCarDto(car2)).willReturn(carDto2);

        //When
        List<CarDto> resultCarsDto = carService.getAllCars();

        //Then
        List<CarDto> expectedCarsDto = List.of(carDto1, carDto2);
        assertEquals(expectedCarsDto, resultCarsDto);
    }

    @Test
    public void given_carIdAndCarDto_when_updateCar_then_carDto(){
        //Given
        Car car = new Car();
        car.setBrand("BRAND");
        car.setModel("MODEL");
        Long carId = 6L;
        car.setId(carId);
        String brand = "NEW_BRAND";
        String model = "NEW_MODEL";
        CarDto carDto = new CarDto(brand,model);

        given(carRepository.existsById(carId)).willReturn(true);
        given(carRepository.getReferenceById(carId)).willReturn(car);
        given(carConverter.fromCarEntityToCarDto(car)).willReturn(carDto);

        //When
        CarDto result = carService.updateCar(carId,carDto);

        //Then
        then(carRepository).should().save(car);
        assertEquals(carDto, result);








    }

    @Test
    public void given_carId_when_deleteCar_then_deleted(){
        //Given
        given(carRepository.existsById(6L)).willReturn(true);

        //When
        carService.deleteCar(6L);

        //Then
        then(carRepository).should().deleteById(6L);

    }

    // https://www.baeldung.com/junit-assert-exception
}