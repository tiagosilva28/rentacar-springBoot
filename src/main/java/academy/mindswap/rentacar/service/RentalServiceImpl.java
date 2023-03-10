package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.RentalConverter;
import academy.mindswap.rentacar.dto.RentalCreateDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService{

    RentalRepository rentalRepository;
    RentalConverter rentalConverter = new RentalConverter();
    @Override
    public RentalDto createRental(RentalCreateDto rentalCreateDto) {
        Rental rental = rentalConverter.fromRentalCreateDtoToEntity(rentalCreateDto, );
        rental = rentalRepository.save(rental);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }



    @Override
    public RentalDto getRentalById(Long rentalId) {
        return null;
    }

    @Override
    public List<RentalDto> getAllRental() {
        return null;
    }

    @Override
    public RentalDto updateRental(Long id, RentalDto rental) {
        return null;
    }

    @Override
    public void deleteRental(Long rentalId) {

    }
}
