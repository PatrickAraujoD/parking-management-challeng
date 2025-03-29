package com.patrickaraujo.parking_management_challenge.infra.dtos.establishment;

public record EstablishmentDTO(
  String name,
  String address,
  String cnpj,
  String phone,
  int numberOfSpacesMotorcycles,
  int numberOfSpacesCars
) {
  
}
