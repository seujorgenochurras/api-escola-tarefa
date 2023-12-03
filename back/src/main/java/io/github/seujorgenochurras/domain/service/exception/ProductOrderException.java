package io.github.seujorgenochurras.domain.service.exception;

public class ProductOrderException extends RuntimeException{
    public ProductOrderException() {
    }

    public ProductOrderException(String message) {
        super(message);
    }

    public ProductOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductOrderException(Throwable cause) {
        super(cause);
    }

    public ProductOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
