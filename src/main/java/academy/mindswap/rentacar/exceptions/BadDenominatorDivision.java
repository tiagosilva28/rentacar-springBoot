package academy.mindswap.rentacar.exceptions;

public class BadDenominatorDivision extends RuntimeException {
    public BadDenominatorDivision(String cannotDivideByZero) {
        super(cannotDivideByZero);
    }
}
