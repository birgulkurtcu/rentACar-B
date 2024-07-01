package com.tobeto.rentACar.core.utilities.mapping.exception.types.handlers;

import com.tobeto.rentACar.core.utilities.mapping.exception.types.problemDetails.ValidationProblemDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler ({ MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus. BAD_REQUEST )
    public ValidationProblemDetails handleValidationException (MethodArgumentNotValidException exception) {

        Map<String , String> validationErrors = new HashMap<>() ;

        exception.getBindingResult().getFieldErrors().stream().map(error ->
                validationErrors.put(error.getField() , error.getDefaultMessage())
        ).toList();

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;
    }
}