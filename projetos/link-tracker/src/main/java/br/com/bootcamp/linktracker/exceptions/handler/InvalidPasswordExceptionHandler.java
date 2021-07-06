package br.com.bootcamp.linktracker.exceptions.handler;

import br.com.bootcamp.linktracker.dtos.ExceptionDTO;
import br.com.bootcamp.linktracker.exceptions.InvalidPasswordException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidPasswordExceptionHandler {

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(InvalidPasswordException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }
}
