package academy.mindswap.rentacar.exceptions;

public class UserNotMatch extends RuntimeException{
    public UserNotMatch(String message) {
        super(message);
    }
}
