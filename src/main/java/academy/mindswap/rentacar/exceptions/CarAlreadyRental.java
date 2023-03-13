package academy.mindswap.rentacar.exceptions;

public class CarAlreadyRental extends RuntimeException{

    public CarAlreadyRental(String message) {
        super(message);
    }
}
