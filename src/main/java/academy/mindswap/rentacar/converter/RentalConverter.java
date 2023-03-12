package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.*;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalConverter {

    //@Autowired
    private CarConverter carConverter = new CarConverter();

    public RentalDto fromRentalEntityToRentalDto(Rental rental) {
        return RentalDto.builder()
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .user_id(rental.getUser().getId())
                .carIds(carConverter.fromCarsEntityToCardsIds(rental.getCars()))
                .cars(rental.getCars().stream()
                        .map(carConverter::fromCarEntityToCarDto)
                        .collect(Collectors.toList()))
                //.carIds(List.of(1L,2L))
                .build();
    }
    /*
    public Rental fromRentalDtoToRentalEntity(RentalDto rentalDto, User user) {
        return Rental.builder()
                .startDate(rentalDto.getStartDate())
                .endDate(rentalDto.getEndDate())
                .user(user)
                .carIds(rentalDto.getCarIds())
                .build();
    }

     */

    public Rental fromRentalCreateDtoToEntity(RentalCreateDto rentalCreateDto, List<Car> cars, User user){
        //List<Long> carId = List.of(car.getId());
        return Rental.builder()
                .startDate(rentalCreateDto.getStartDate())
                .endDate(rentalCreateDto.getEndDate())
                .user(user)
                .cars(cars)
                .build();
    }
}
