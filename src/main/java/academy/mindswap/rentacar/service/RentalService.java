package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.RentalCreateDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.User;

import java.util.List;

public interface RentalService {

    RentalDto createRental(RentalCreateDto rental, User user, Car car);
    RentalDto getRentalById(Long rentalId);
    List<RentalDto> getAllRental();

    RentalDto updateRental(Long id, RentalDto rental);

    void deleteRental(Long rentalId);


}
