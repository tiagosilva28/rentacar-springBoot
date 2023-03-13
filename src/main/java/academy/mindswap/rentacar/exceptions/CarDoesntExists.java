package academy.mindswap.rentacar.exceptions;

public class CarDoesntExists extends RuntimeException{

    public CarDoesntExists(String message) {
        super(message);
    }
}
