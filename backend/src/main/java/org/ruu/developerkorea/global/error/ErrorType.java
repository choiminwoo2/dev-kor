package org.ruu.developerkorea.global.error;

import lombok.Getter;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {

    DEFAULT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.B500, "error on default", LogLevel.ERROR),
    ARGUMENTS_NOT_VALID(HttpStatus.BAD_REQUEST, ErrorCode.B01_400, "arguments not valid", LogLevel.WARN),
    ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST, ErrorCode.B01_400, "entity not found", LogLevel.ERROR),

    //comment

    //post


    ;
    private final HttpStatus httpStatus;

    private final ErrorCode errorCode;

    private final String message;

    private final LogLevel logLevel;

    ErrorType(HttpStatus httpStatus, ErrorCode errorCode, String message, LogLevel logLevel) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
        this.logLevel = logLevel;
    }


}
