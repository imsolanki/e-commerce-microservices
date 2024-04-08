package com.codemagic.productservice.exception;

import com.codemagic.productservice.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/*
    * Class used to create custom error messages by taking fields provided in Error Details class only.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //handle specific exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(
                new Date(), exception.getMessage(), webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ProductAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleProductAlreadyPresentException(ProductAlreadyExistException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(
                new Date(), exception.getMessage(), webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //handle global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                                             WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(
                new Date(), exception.getMessage(), webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
