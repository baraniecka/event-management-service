package pl.sda.orange.java2.event.exception;

import lombok.Value;

@Value
public class ValidationError {

    String code;

    String reason;
}
