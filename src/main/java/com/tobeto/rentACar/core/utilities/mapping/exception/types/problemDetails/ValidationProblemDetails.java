package com.tobeto.rentACar.core.utilities.mapping.exception.types.problemDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails (){
        setTitle( "Validation Rule Violation" ) ;
        setDetail( "Validation Problem" ) ;
        setType( "http://mydomain.com/exceptions/validation" ) ;
        setStatus( "400" ) ;
    }

    private Map<String,String> errors ;

    public void setErrors(Map<String,String> validationErrors) {
    }
}