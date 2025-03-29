package com.patrickaraujo.parking_management_challenge.core.exceptions;

public class EstablishmentNotFoundException extends RuntimeException {
  public EstablishmentNotFoundException(String message) {
    super(message);
  }
}
