package academy.mindswap.rentacar.exceptions;

public class UserDoesntExists extends RuntimeException{
    public UserDoesntExists(String message) {
        super(message);
    }
}
