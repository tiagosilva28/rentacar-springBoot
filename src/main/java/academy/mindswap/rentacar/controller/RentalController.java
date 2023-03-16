package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.RentalCreateDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.dto.UserCreateDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.service.RentalService;
import jakarta.validation.Valid;
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

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> getById(@PathVariable Long id) {
        RentalDto rental = rentalService.getRentalById(id);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<RentalDto> createRental(@RequestBody RentalCreateDto rental) {

        RentalDto savedRental = rentalService.createRental(rental);
        return new ResponseEntity<>(savedRental, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<RentalDto> updateRental(@PathVariable Long id, @Valid @RequestBody RentalDto rentalDto, BindingResult bindingResult){
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
    public ResponseEntity<RentalDto> deleteRental(@PathVariable Long id){

        rentalService.deleteRental(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }





}
