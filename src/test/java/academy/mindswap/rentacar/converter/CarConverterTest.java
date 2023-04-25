package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.CarCreateDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarConverterTest {

    private CarConverter carConverter = new CarConverter();

    @Test
    public void given_car_when_convertingToDto_then_carDto() {
        // Given
        Car car = new Car();
        car.setBrand("ANY_BRAND");
        car.setModel("ANY_MODEL");

        // When
        CarDto result = carConverter.fromCarEntityToCarDto(car);

        // Then
        assertEquals(car.getBrand(), result.getBrand());
        assertEquals(car.getModel(), result.getModel());
    }

    @Test
    public void given_carCreateDto_when_convertingToEntity_then_car(){
        //Given
        CarCreateDto carCreateDto = new CarCreateDto();
        carCreateDto.setBrand("ANY_BRAND");
        carCreateDto.setModel("ANY_MODEL");

        //when
        Car result = carConverter.fromCarCreateDtoToEntity(carCreateDto);

        //Then
        assertEquals(carCreateDto.getBrand(), result.getBrand());
        assertEquals(carCreateDto.getModel(), result.getModel());

    }

    @Test
    public void given_listCars_when_convertingToListCarsId_then_listCardIds(){
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        Long car1Id = 1L;
        Long car2Id = 4L;
        car1.setId(car1Id);
        car2.setId(car2Id);
        List<Car> cars = List.of(car1,car2);
        List<Long> expectedCarsId = List.of(car1.getId(),car2.getId());

        //when
        List<Long> result = carConverter.fromCarsEntityToCardsIds(cars);

        //then
        assertEquals(expectedCarsId, result);
    }
    @Test
    public void given_listCars_when_convertingToListCarDto_then_listCarsDto(){

        Car car1 = new Car();
        Car car2 = new Car();
        car1.setBrand("CAR1_BRAND");
        car1.setModel("CAR1_MODEL");
        car2.setBrand("CAR2_BRAND");
        car2.setModel("CAR2_MODEL");
        List<Car> cars = List.of(car1,car2);

        CarDto carDto1 = new CarDto();
        CarDto carDto2 = new CarDto();
        carDto1.setBrand(car1.getBrand());
        carDto1.setModel(car1.getModel());
        carDto2.setBrand(car2.getBrand());
        carDto2.setModel(car2.getModel());
        List<CarDto> expectedListCarsDto = List.of(carDto1, carDto2);

        //when

        List<CarDto> result = carConverter.fromCarsEntityListToCarsDtoList(cars);

        //then
        assertEquals(expectedListCarsDto, result);

    }

}