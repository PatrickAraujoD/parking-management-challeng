package com.patrickaraujo.parking_management_challenge.core.usecases.establishment;

import com.patrickaraujo.parking_management_challenge.core.models.Establishment;

public interface GetEstablishmentById {
  Establishment get(String id);
}
