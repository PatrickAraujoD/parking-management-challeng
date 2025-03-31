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
    return new EstablishmentEntity(establishmentDomain.getId(), establishmentDomain.getName(), establishmentDomain.getCnpj(), addressEntity, establishmentDomain.getPhone(), establishmentDomain.getNumberOfSpacesMotorcycles(), establishmentDomain.getNumberOfSpacesCars());
  } 

  Establishment toDomain(EstablishmentEntity establishmentEntity) {
    Address address = this.addressMapper.toModel(establishmentEntity.getAddress());
    return new Establishment(establishmentEntity.getId(), establishmentEntity.getName(), establishmentEntity.getCnpj(), address, establishmentEntity.getPhone(), establishmentEntity.getNumberOfSpacesMotorcycles(), establishmentEntity.getNumberOfSpacesCars());
  }
}
