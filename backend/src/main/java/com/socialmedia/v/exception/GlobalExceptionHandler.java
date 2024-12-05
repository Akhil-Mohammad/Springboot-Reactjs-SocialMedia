package com.socialmedia.v.exception;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(RuntimeException exception){
        ErrorResponse errorResponse = new ErrorResponse(400 , "Bad request", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception){
        ErrorResponse errorResponse = new ErrorResponse(500, "Internal server Error", exception.getMessage());
        return  new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(RuntimeException exception){
        ErrorResponse errorResponse = new ErrorResponse(500, "Internal server Error", exception.getMessage());
        return  new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(RuntimeException exception){
        ErrorResponse errorResponse = new ErrorResponse(404, "Not Found", exception.getMessage());
        return  new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex){
        ErrorResponse response = new ErrorResponse(Integer.parseInt(ex.getCode()), ex.getStatus(), ex.getDetails());
        return  new ResponseEntity<>(response, HttpStatusCode.valueOf(204));
    }
}
