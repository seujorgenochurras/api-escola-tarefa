package io.github.seujorgenochurras.front.exception;

public class UserNotSellerException extends RuntimeException{
    public UserNotSellerException() {
    }

    public UserNotSellerException(String message) {
        super(message);
    }

    public UserNotSellerException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotSellerException(Throwable cause) {
        super(cause);
    }

    public UserNotSellerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
