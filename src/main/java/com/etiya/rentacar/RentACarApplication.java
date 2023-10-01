package com.etiya.rentacar;

import com.etiya.rentacar.core.utilities.exceptions.BusinessException;
import com.etiya.rentacar.core.utilities.exceptions.ProblemDetails;
import com.etiya.rentacar.core.utilities.exceptions.ValidationProblemDetails;
import com.etiya.rentacar.core.utilities.mappers.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }
@ExceptionHandler
@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public ProblemDetails handleBusinessException(BusinessException businessException) {
        ProblemDetails problemDetails =new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationproblemDetails =new ValidationProblemDetails();
        validationproblemDetails.setMessage("VALIDATION.EXCEPTION");
        validationproblemDetails.setValidationErrors(new HashMap<String, String>());

        //validationproblemDetails.getValidationErrors().put()
        for(FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationproblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return validationproblemDetails;
    }


    @Bean // bu bir nesne ve constructorda ihtiyacım olacak
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
