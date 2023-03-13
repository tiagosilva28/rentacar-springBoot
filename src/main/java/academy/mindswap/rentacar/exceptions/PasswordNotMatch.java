package academy.mindswap.rentacar.exceptions;

public class PasswordNotMatch extends RuntimeException {
    public PasswordNotMatch(String wrongPassword){
        super(wrongPassword);
    }

}
