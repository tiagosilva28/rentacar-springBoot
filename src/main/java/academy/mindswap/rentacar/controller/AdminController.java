package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.CarCreateDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.service.CarService;
import academy.mindswap.rentacar.service.RentalService;
import academy.mindswap.rentacar.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Data
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    @Autowired
    private RentalService rentalService;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return userDtos;
    }

    @PostMapping("/car")
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarCreateDto car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }
        CarDto savedCar = carService.createCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @Valid @RequestBody CarDto carDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }

        CarDto updatedCar = carService.updateCar(id, carDto);
        return new ResponseEntity<>(updatedCar, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<CarDto> deleteCar(@PathVariable Long id){
        /*if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }

         */
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/rental")
    public ResponseEntity<List<RentalDto>> getAllRentals(){
        List<RentalDto> rentalDtos = rentalService.getAllRental();
        return new ResponseEntity<>(rentalDtos, HttpStatus.OK);
    }

}
