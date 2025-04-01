package com.patrickaraujo.parking_management_challenge.application.vehicle;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.adapters.VehicleRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.AlreadyExistsException;
import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.AddVehicle;

public class AddVehicleService implements AddVehicle {
  private VehicleRepository vehicleRepository;

  public AddVehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public Vehicle add(Vehicle vehicle) {
    Optional<Vehicle> vehicleExists = this.vehicleRepository.findByPlate(vehicle.getPlate());
    if (vehicleExists.isEmpty()) {
      throw new AlreadyExistsException("There is already a registered vehicle with an informed license plate");
    }
    Vehicle newVehicle = this.vehicleRepository.save(vehicle);
    return newVehicle;
  }
}
