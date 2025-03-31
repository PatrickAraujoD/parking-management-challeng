package com.patrickaraujo.parking_management_challenge.core.usecases.establishment;

import com.patrickaraujo.parking_management_challenge.core.models.Address;
import com.patrickaraujo.parking_management_challenge.core.models.Establishment;

public interface UpdateEstablishment {
  void update(String id, String name, Address address, String phone, Integer numberOfSpaceMotorcycles, Integer numberOfSpaceCars) throws Exception;
  void copyNonNullFields(Establishment source, Establishment target) throws Exception;
}