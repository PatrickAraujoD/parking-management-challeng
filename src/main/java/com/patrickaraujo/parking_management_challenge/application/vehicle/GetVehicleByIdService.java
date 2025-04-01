package com.patrickaraujo.parking_management_challenge.application.vehicle;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.adapters.VehicleRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.VehicleNotFoundException;
import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.GetVehicleById;

public class GetVehicleByIdService implements GetVehicleById {
  private final VehicleRepository vehicleRepository;

  public GetVehicleByIdService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public Vehicle get (String id) {
    Optional<Vehicle> vehicle = this.vehicleRepository.findById(id);
    if (vehicle.isEmpty()) {
      throw new VehicleNotFoundException("Vehicle not found with id: " + id);
    }
    return vehicle.get();
  }
}
