package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.RentalCreateDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.repository.CarRepository;
import academy.mindswap.rentacar.repository.RentalRepository;
import academy.mindswap.rentacar.service.RentalService;
import jakarta.validation.Valid;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")

public class RentalController {

    private RentalService rentalService;
    private RentalRepository rentalRepository;
    private CarRepository carRepository;

    @Autowired
    public RentalController(RentalService rentalService, RentalRepository rentalRepository, CarRepository carRepository) {
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<RentalDto>> getAllRentals() {
        List<RentalDto> rentalDtos = rentalService.getAllRental();
        return new ResponseEntity<>(rentalDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> getById(@PathVariable Long id) {
        RentalDto rental = rentalService.getRentalById(id);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentalDto> createRental(@RequestBody RentalCreateDto rental, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }
        RentalDto savedRental = rentalService.createRental(rental);
        return new ResponseEntity<>(savedRental, HttpStatus.CREATED);
    }

    @PostMapping("/rentals/{rentalId}/cars/{carId}")
    public Rental addCarToRental(@PathVariable Long rentalId, @PathVariable Long carId) {
        Rental rental = rentalRepository.findById(rentalId).orElseThrow(() -> new ResourceNotFoundException("Rental not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car not found"));
        rental.addCar(car);
        return rentalRepository.save(rental);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDto> updateRental(@PathVariable Long id, @Valid @RequestBody RentalDto rentalDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }

        RentalDto updateRental = rentalService.updateRental(id, rentalDto);
        return new ResponseEntity<>(updateRental, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RentalDto> deleteUser(@PathVariable Long id) {

        rentalService.deleteRental(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
