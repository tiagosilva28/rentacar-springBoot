package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.RentalCreateDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;

public class RentalConverter {

    private UserRepository userRepository;

    public RentalDto fromRentalEntityToRentalDto(Rental rental) {
        return RentalDto.builder()
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .user_id(rental.getUser().getId())
                .build();
    }

    public Rental fromRentalDtoToRentalEntity(RentalDto rentalDto) {

        User user = userRepository.findById(rentalDto.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return Rental.builder()
                .startDate(rentalDto.getStartDate())
                .endDate(rentalDto.getEndDate())
                .user(user)
                .build();
    }

    public Rental fromRentalCreateDtoToEntity(RentalCreateDto rentalCreateDto) {

        User user = userRepository.findById(rentalCreateDto.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));


        return Rental.builder()
                .startDate(rentalCreateDto.getStartDate())
                .endDate(rentalCreateDto.getEndDate())
                .user(user)
                .build();
    }


}
