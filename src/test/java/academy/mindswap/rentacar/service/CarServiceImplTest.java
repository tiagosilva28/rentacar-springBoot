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

    // https://www.baeldung.com/junit-assert-exception
}