package com.patrickaraujo.parking_management_challenge.infra.dtos.establishment;

import com.patrickaraujo.parking_management_challenge.core.models.Address;

public record EstablishmentDTO(
  String id,
  String name,
  Address address,
  String cnpj,
  String phone,
  int numberOfSpacesMotorcycles,
  int numberOfSpacesCars
) {
  
}
