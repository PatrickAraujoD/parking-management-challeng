package com.patrickaraujo.parking_management_challenge.application.vehicle;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.adapters.VehicleRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.VehicleNotFoundException;
import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateVehicle;

public class UpdateVehicleService implements UpdateVehicle {
  private VehicleRepository vehicleRepository;

  public UpdateVehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public void update(String id, String color) {
    Optional<Vehicle> vehicleExists = this.vehicleRepository.findById(id);
    if (!vehicleExists.isPresent()) {
      throw new VehicleNotFoundException("Vehicle not found with id: " + id);
    }
    Vehicle vehicle = vehicleExists.get();
    vehicle.setColor(color);
    this.vehicleRepository.save(vehicle);
  }
  
}
