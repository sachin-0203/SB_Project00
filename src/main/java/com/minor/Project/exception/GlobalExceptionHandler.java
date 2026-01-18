package com.minor.Project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.minor.Project.dto.ApiErrorDto;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler{
  
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleAll(Exception ex) {
    ex.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getClass().getName());
  }
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiErrorDto> resourceNotFoundExceptionHandler(ResourceNotFoundException ex, HttpServletRequest request){
    
    ApiErrorDto error = new ApiErrorDto(
      LocalDateTime.now(),
      HttpStatus.NOT_FOUND.value(),
      HttpStatus.NOT_FOUND.name(),
      ex.getMessage(),
      request.getRequestURI()
    );

    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiErrorDto> handleValidationException(MethodArgumentNotValidException ex , HttpServletRequest request){

    String message = ex.getBindingResult().getFieldErrors().stream().findFirst().map(FieldError:: getDefaultMessage).orElse("Validation Failed");
    
    ApiErrorDto error = new ApiErrorDto(
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST.value(),
      HttpStatus.BAD_REQUEST.name(),
      message,
      request.getRequestURI()
    );

    return ResponseEntity.badRequest().body(error);
  }

}