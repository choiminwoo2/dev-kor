package org.ruu.developerkorea.global.advice;

import org.ruu.developerkorea.global.error.BusinessException;
import org.ruu.developerkorea.global.error.EntityNotFoundException;
import org.ruu.developerkorea.global.error.ErrorType;
import org.ruu.developerkorea.global.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "org.ruu.developerkorea.domain")
public class GlobalExceptionAdvice {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<?>> handleBusinessException(final BusinessException e) {
        switch (e.getErrorType().getLogLevel()) {
            case ERROR -> log.error("Business Exception : {}", e.getMessage(), e);
            case WARN -> log.warn("Business Exception : {}", e.getMessage(), e);
            default -> log.info("Business Exception : {}", e.getMessage(), e);
        }
        return new ResponseEntity<>(ApiResponse.error(e.getErrorType(), e.getData()
        ), e.getErrorType().getHttpStatus());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleDataAccessException(final DataAccessException e) {
        log.error("Exception : {}", e.getMessage());
        return new ResponseEntity<>(ApiResponse.error(ErrorType.DEFAULT_ERROR), ErrorType.DEFAULT_ERROR.getHttpStatus());
    }
}
