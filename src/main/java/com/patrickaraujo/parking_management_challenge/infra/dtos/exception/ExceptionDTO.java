package com.patrickaraujo.parking_management_challenge.infra.dtos.exception;

public record ExceptionDTO(
  String message,
  String statusCode
) {

}
