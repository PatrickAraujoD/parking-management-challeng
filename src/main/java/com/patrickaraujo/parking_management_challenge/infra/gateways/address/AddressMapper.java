package com.patrickaraujo.parking_management_challenge.infra.gateways.address;

import com.patrickaraujo.parking_management_challenge.infra.persistence.address.AddressEntity;
import com.patrickaraujo.parking_management_challenge.core.models.Address;


public class AddressMapper {
  public AddressEntity toEntity(Address address) {
    return new AddressEntity(address.getRoad(), address.getNumber(), address.getComplement(), address.getCity(), address.getState(), address.getCep());
  }

  public Address toModel(AddressEntity addressEntity) {
    return new Address(addressEntity.getRoad(), addressEntity.getNumber(), addressEntity.getComplement(), addressEntity.getCity(), addressEntity.getState(), addressEntity.getCep());
  }
}
