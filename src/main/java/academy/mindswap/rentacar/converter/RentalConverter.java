package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.*;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;

import java.util.List;

public class RentalConverter {

    public RentalDto fromRentalEntityToRentalDto(Rental rental) {
        return RentalDto.builder()
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .user_id(rental.getUser().getId())
                .build();
    }

    public Rental fromRentalDtoToRentalEntity(RentalDto rentalDto, User user) {
        return Rental.builder()
                .startDate(rentalDto.getStartDate())
                .endDate(rentalDto.getEndDate())
                .user(user)
                .build();
    }

    public Rental fromRentalCreateDtoToEntity(RentalCreateDto rentalCreateDto, User user){
        return Rental.builder()
                .startDate(rentalCreateDto.getStartDate())
                .endDate(rentalCreateDto.getEndDate())
                .user(user)
                .build();
    }


}
