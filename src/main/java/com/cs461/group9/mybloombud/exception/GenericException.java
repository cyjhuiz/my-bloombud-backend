package com.cs461.group9.mybloombud.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
public class GenericException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private final ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("Z"));

    public GenericException(String message) { this.message = message; }
}
