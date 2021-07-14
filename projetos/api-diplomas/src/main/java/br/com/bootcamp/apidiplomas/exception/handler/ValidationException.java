package br.com.bootcamp.apidiplomas.exception.handler;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}
