package academy.mindswap.rentacar.aspects;

import academy.mindswap.rentacar.exceptions.CarAlreadyRental;
import academy.mindswap.rentacar.exceptions.CarDoesntExists;
import academy.mindswap.rentacar.exceptions.PasswordNotMatch;
import academy.mindswap.rentacar.exceptions.UserDoesntExists;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@Component
@ControllerAdvice
public class GenericExceptionHandler {

    Logger logger =  LoggerFactory.getLogger(GenericExceptionHandler.class);

    @ExceptionHandler({PasswordNotMatch.class})
    public ResponseEntity<String> handleNotFoundException(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Password doesn't match");
    }

    @ExceptionHandler({CarAlreadyRental.class})
    public ResponseEntity<String> handleCarAlreadyRental(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Car or Cars already Rental");
    }

    @ExceptionHandler({CarDoesntExists.class})
    public ResponseEntity<String> handleCarDoesntExists(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car doesn't Exists");
    }

    @ExceptionHandler({UserDoesntExists.class})
    public ResponseEntity<String> handleUserDoesntExists(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Doesn't exists");
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(EntityNotFoundException ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found");
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Unknown Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
    }


}
