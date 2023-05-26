package pl.sda.orange.java2.event.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class EventExceptionHandler {

    @ExceptionHandler(NoSuchEventException.class)
    public ResponseEntity noSuchEventExceptionHandler(NoSuchEventException nse){

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(nse.getMessage());

        return ResponseEntity
                .status(404)
                .body(errorDto);
    }

}
