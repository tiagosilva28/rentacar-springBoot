package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.CarCreateDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.UserCreateDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> carDtos = carService.getAllCars();
        return new ResponseEntity<>(carDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable Long id) {
        CarDto car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }



}
