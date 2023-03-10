package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.CarCreateDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static academy.mindswap.rentacar.dto.CarDto.*;
import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

public class CarConverter {

    @Autowired
    ObjectMapper objectMapper;

    public CarDto fromCarEntityToCarDto(Car car) {
        return CarDto.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .build();
    }

    public Car fromCarDtoToCarEntity(CarDto carDto){
        return Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .build();
    }

    public Car fromCarCreateDtoToEntity(CarCreateDto carCreateDto){
        return Car.builder()
                .brand(carCreateDto.getBrand())
                .model(carCreateDto.getModel())
                .build();
    }
}
