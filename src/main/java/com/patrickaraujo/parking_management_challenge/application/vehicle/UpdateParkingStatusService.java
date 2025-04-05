package com.patrickaraujo.parking_management_challenge.application.vehicle;

import com.patrickaraujo.parking_management_challenge.adapters.VehicleRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.VehicleIsParkedException;
import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateParkingStatus;

public class UpdateParkingStatusService implements UpdateParkingStatus {
  private final VehicleRepository vehicleRepository;

  public UpdateParkingStatusService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public void markAsParked(Vehicle vehicle, boolean parked) {
    if (parked && vehicle.isParked()) {
      throw new VehicleIsParkedException("The reported vehicle is already parked");
    }
    vehicle.setParked(parked);
    this.vehicleRepository.save(vehicle);
  }
}
