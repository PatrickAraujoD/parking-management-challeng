package com.patrickaraujo.parking_management_challenge.core.exceptions;

public class VehicleNotFoundException extends RuntimeException {
  public VehicleNotFoundException(String message) {
    super(message);
  }
}
