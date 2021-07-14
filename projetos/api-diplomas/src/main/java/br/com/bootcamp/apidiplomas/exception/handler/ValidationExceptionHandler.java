package br.com.bootcamp.apidiplomas.exception.handler;

import br.com.bootcamp.apidiplomas.exception.ValidationExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ValidationExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationExceptionDTO>> validationException (MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ValidationExceptionDTO> processFieldErrors = processFieldErrors(fieldErrors);
        return ResponseEntity.badRequest().body(processFieldErrors);
    }

    private List<ValidationExceptionDTO> processFieldErrors(List<FieldError> fieldErrors) {
        List<ValidationExceptionDTO> listaDtosErros = new ArrayList<>();
        fieldErrors.forEach(fe -> {
            String mensagemErro = messageSource.getMessage(fe, LocaleContextHolder.getLocale());
            listaDtosErros.add(new ValidationExceptionDTO(fe.getField(), mensagemErro));
        });
        return listaDtosErros;
    }
}
