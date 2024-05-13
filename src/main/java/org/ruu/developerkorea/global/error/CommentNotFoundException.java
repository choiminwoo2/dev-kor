package org.ruu.developerkorea.global.error;

public class CommentNotFoundException extends EntityNotFoundException {
    public CommentNotFoundException(ErrorType errorType) {
        super(errorType);
    }

    public CommentNotFoundException(ErrorType errorType, Object data) {
        super(errorType, data);
    }
}
