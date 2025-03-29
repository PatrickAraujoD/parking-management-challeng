package com.patrickaraujo.parking_management_challenge.infra.controller.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.patrickaraujo.parking_management_challenge.core.exceptions.AlreadyExistsException;
import com.patrickaraujo.parking_management_challenge.infra.dtos.exception.ExceptionDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(AlreadyExistsException.class)
  public ResponseEntity<ExceptionDTO> handleAlreadyExistsException(AlreadyExistsException exception) {
    return ResponseEntity.badRequest().body(new ExceptionDTO(exception.getMessage(), "400"));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionDTO> handleGlobalException(Exception exception) {
    return ResponseEntity.badRequest().body(new ExceptionDTO("An error has occurred. Try again later", "500"));
  }
}
