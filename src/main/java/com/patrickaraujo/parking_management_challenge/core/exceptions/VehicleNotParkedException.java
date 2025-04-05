package com.patrickaraujo.parking_management_challenge.core.exceptions;

public class VehicleNotParkedException extends RuntimeException {
  public VehicleNotParkedException(String message) {
    super(message);
  }
}
