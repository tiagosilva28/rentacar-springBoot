package academy.mindswap.rentacar.aspects;


import academy.mindswap.rentacar.exceptions.BadDenominatorDivision;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;


@Component
@ControllerAdvice
public class UserExceptionHandler {

    Logger logger =  LoggerFactory.getLogger(UserExceptionHandler.class);

    /*
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, NumberFormatException.class, ArithmeticException.class, BadDenominatorDivision.class})
    public ResponseEntity<String> handleDivisionByZero(Exception ex) {
        logger.error("Known Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

     */

    // Test implementation
    /*
        @ExceptionHandler(value = {ResourceNotFoundException.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String handleGenericException(ResourceNotFoundException ex) {
            logger.error("Resource not found: " + ex);
            return "An error occurred. HAHAHA";
        }

     */
    //error 404
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ChangeSetPersister.NotFoundException ex) {
        logger.error("Unknown Exception error404: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
    }

    //error 500 is working
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Unknown Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
    }




}
