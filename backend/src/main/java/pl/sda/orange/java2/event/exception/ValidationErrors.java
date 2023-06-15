package pl.sda.orange.java2.event.exception;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ValidationErrors {

    @Singular
    List<ValidationError> errors;
}
