package com.patrickaraujo.parking_management_challenge.core.usecases.vehicles;

import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;

public interface GetVehicleById {
  Vehicle get (String id);
}
