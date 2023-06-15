package pl.sda.orange.java2.event.exception;

import lombok.Getter;

@Getter
public class PropertyMissingException extends RuntimeException {

    private final String fieldName;

    public PropertyMissingException(String fieldName) {
        super("Missing field: " + fieldName);
        this.fieldName = fieldName;
    }


}
