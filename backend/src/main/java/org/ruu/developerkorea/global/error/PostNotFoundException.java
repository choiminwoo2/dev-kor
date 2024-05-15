package org.ruu.developerkorea.global.error;

public class PostNotFoundException extends EntityNotFoundException {
    public PostNotFoundException(ErrorType errorType) {
        super(errorType);
    }

    public PostNotFoundException(ErrorType errorType, Object data) {
        super(errorType, data);
    }
}
