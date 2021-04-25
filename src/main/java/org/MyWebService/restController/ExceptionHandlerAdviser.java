package org.MyWebService.restController;

import org.MyWebService.exceptions.DataValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class ExceptionHandlerAdviser {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Error 500")
    public void handleUncheckedExceptions(RuntimeException exception) {
    }

    @ExceptionHandler(DataValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Error 400")
    public void handleValidationExceptions(DataValidationException exception) {
    }
}

