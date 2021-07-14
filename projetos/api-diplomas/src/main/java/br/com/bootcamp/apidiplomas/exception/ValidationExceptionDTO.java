package br.com.bootcamp.apidiplomas.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationExceptionDTO {

    private String campo;
    private String message;

    public static class ValidationException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public ValidationException() {
        }

        public ValidationException(String message) {
            super(message);
        }
    }
}
