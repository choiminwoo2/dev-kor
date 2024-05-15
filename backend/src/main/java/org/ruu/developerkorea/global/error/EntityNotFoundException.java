package org.ruu.developerkorea.global.error;

public class EntityNotFoundException extends BusinessException {
    public EntityNotFoundException(ErrorType errorType) {
        super(errorType);
    }

    public EntityNotFoundException(ErrorType errorType, Object data) {
        super(errorType, data);
    }
}
