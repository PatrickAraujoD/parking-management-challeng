package com.patrickaraujo.parking_management_challenge.infra.gateways.vehicle;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.adapters.VehicleRepository;
import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.infra.persistence.vehicle.VehicleEntity;
import com.patrickaraujo.parking_management_challenge.infra.persistence.vehicle.VehicleRepositoryJpa;

public class VehicleRepositoryGateway implements VehicleRepository {
  private VehicleRepositoryJpa vehicleRepositoryJpa;
  private VehicleMapper vehicleMapper;

  public VehicleRepositoryGateway(VehicleRepositoryJpa vehicleRepositoryJpa, VehicleMapper vehicleMapper) {
    this.vehicleRepositoryJpa = vehicleRepositoryJpa;
    this.vehicleMapper = vehicleMapper;
  }

  @Override
  public Optional<Vehicle> findById(String id) {
    return this.vehicleRepositoryJpa.findById(id)
        .map(vehicleEntity -> this.vehicleMapper.toDomain(vehicleEntity));
  }

  @Override
  public Optional<Vehicle> findByPlate(String plate) {
    return this.vehicleRepositoryJpa.findByPlate(plate)
        .map(vehicleEntity -> this.vehicleMapper.toDomain(vehicleEntity));
  }

  @Override
  public Vehicle save(Vehicle vehicle) {
    VehicleEntity vehicleEntity = this.vehicleMapper.toEntity(vehicle);
    VehicleEntity newVehicleEntity = this.vehicleRepositoryJpa.save(vehicleEntity);
    return this.vehicleMapper.toDomain(newVehicleEntity);
  }

  @Override
  public void deleteById(String id) {
    this.vehicleRepositoryJpa.deleteById(id); 
  }
}
