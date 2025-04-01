package com.patrickaraujo.parking_management_challenge.adapters;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;

public interface VehicleRepository {
  Optional<Vehicle> findById(String id);
  Optional<Vehicle> findByPlate(String plate);
  Vehicle save(Vehicle vehicle);
  void deleteById(String id);
}
