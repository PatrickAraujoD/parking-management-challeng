package com.patrickaraujo.parking_management_challenge.core.exceptions;

public class VacanciesUnavailableException extends RuntimeException {
  public VacanciesUnavailableException(String message) {
    super(message);
  }
}
