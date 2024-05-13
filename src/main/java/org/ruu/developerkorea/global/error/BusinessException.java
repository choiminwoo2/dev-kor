package org.ruu.developerkorea.global.error;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorType errorType;

    private final Object data;

    public BusinessException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
        this.data = null;
    }

    public BusinessException(ErrorType errorType, Object data) {
        super(errorType.getMessage());
        this.errorType = errorType;
        this.data = data;
    }
}
