package com.patrickaraujo.parking_management_challenge.infra.gateways.establishment;

import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.infra.gateways.address.AddressMapper;
import com.patrickaraujo.parking_management_challenge.infra.persistence.address.AddressEntity;
import com.patrickaraujo.parking_management_challenge.infra.persistence.establishment.EstablishmentEntity;
import com.patrickaraujo.parking_management_challenge.core.models.Address;

public class EstablishmentMapper {
  private final AddressMapper addressMapper;

  public EstablishmentMapper(AddressMapper addressMapper) {
    this.addressMapper = addressMapper;
  }

  EstablishmentEntity toEntity(Establishment establishmentDomain) {
    AddressEntity addressEntity = this.addressMapper.toEntity(establishmentDomain.getAddress());
    return new EstablishmentEntity(establishmentDomain.getName(), addressEntity, establishmentDomain.getCnpj(), establishmentDomain.getPhone(), establishmentDomain.getNumber_of_spaces_motorcycles(), establishmentDomain.getNumber_of_spaces_cars());
  } 

  Establishment toDomain(EstablishmentEntity establishmentEntity) {
    Address address = this.addressMapper.toModel(establishmentEntity.getAddress());
    return new Establishment(establishmentEntity.getName(), establishmentEntity.getCnpj(), address, establishmentEntity.getPhone(), establishmentEntity.getNumber_of_spaces_motorcycles(), establishmentEntity.getNumber_of_spaces_cars());
  }
}
