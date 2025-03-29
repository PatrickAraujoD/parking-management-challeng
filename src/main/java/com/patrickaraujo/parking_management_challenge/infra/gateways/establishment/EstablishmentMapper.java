package com.patrickaraujo.parking_management_challenge.infra.gateways.establishment;

import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.infra.persistence.establishment.EstablishmentEntity;

public class EstablishmentMapper {
  EstablishmentEntity toEntity(Establishment establishmentDomain) {
    return new EstablishmentEntity(establishmentDomain.getName(), establishmentDomain.getAddress(), establishmentDomain.getCnpj(), establishmentDomain.getPhone(), establishmentDomain.getNumber_of_spaces_motorcycles(), establishmentDomain.getNumber_of_spaces_cars());
  } 

  Establishment toDomain(EstablishmentEntity establishmentEntity) {
    return new Establishment(establishmentEntity.getName(), establishmentEntity.getCnpj(), establishmentEntity.getAddress(), establishmentEntity.getPhone(), establishmentEntity.getNumber_of_spaces_motorcycles(), establishmentEntity.getNumber_of_spaces_cars());
  }
}
