package org.ruu.developerkorea.global.error;

public class BusinessLogicException extends RuntimeException {
    public BusinessLogicException(String msg) {
        super("[Business Logic Exception] " +msg);
    }
}
