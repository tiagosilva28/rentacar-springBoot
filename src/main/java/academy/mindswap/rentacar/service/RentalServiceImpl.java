package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.RentalConverter;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.RentalCreateDto;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.CarRepository;
import academy.mindswap.rentacar.repository.RentalRepository;
import academy.mindswap.rentacar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService{
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;
    private RentalConverter rentalConverter = new RentalConverter();
    @Override
    public RentalDto createRental(RentalCreateDto rentalCreateDto) {
        // obter user da base dados
        // obter cada car da base de dados
        // passar cars and user para converter
        User user = userRepository.getReferenceById(rentalCreateDto.getUserId());
        List<Car> cars = carRepository.findAllById(rentalCreateDto.getCarIds());

        Rental rental = rentalConverter.fromRentalCreateDtoToEntity(rentalCreateDto, cars, user);
        rental = rentalRepository.save(rental);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }



    @Override
    public RentalDto getRentalById(Long rentalId) {
        Rental rental = rentalRepository.getReferenceById(rentalId);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }

    @Override
    public List<RentalDto> getAllRental() {
        List<Rental> rentals = rentalRepository.findAll();
        //rentalConverter.fromRentalEntityToRentalDto(rentals);

        //return carDtos;
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
