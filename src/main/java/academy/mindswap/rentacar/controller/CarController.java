package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

   /* @GetMapping("")
    public Car getCars(){
        return carService.getCars();
    }
    */

    @GetMapping("")
    public ResponseEntity<List<Car>> myFirstEndPoint(){
       List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> createUser(@RequestBody Car car){
        Car savedCar = carService.createCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }
}
