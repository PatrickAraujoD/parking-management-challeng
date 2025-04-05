package com.patrickaraujo.parking_management_challenge.core.exceptions;

public class VehicleIsParkedException extends RuntimeException {
  public VehicleIsParkedException(String message) {
    super(message);
  }
}
