package pl.sda.orange.java2.event.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchEventException.class)
    public ResponseEntity handleNoSuchEvent(NoSuchEventException e){

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        return ResponseEntity
                .status(404)
                .body(errorDto);
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity handleNoUserFound(NoUserFoundException e){

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        return ResponseEntity
                .status(404)
                .body(errorDto);
    }

    @ExceptionHandler(PropertyMissingException.class)
    public ResponseEntity handlePropertyMissingException(PropertyMissingException e){

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        return ResponseEntity
                .status(400)
                .body(errorDto);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ValidationErrors> handleBindException(BindException ex){
        BindingResult bindingResult = ex.getBindingResult();
        var validationErrors = ValidationErrors.builder();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            validationErrors.error(new ValidationError(fieldError.getCode(), fieldError.getDefaultMessage()));
        }

        return ResponseEntity
                .status(400)
                .body(validationErrors.build());
    }

    @ExceptionHandler(EventAlreadyExistsException.class)
    public ResponseEntity handleEventAlreadyExists(EventAlreadyExistsException e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        return ResponseEntity
                .status(409)
                .body(errorDto);
    }

}
