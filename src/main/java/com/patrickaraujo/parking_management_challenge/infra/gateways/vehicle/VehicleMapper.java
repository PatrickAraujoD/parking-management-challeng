package com.patrickaraujo.parking_management_challenge.infra.gateways.vehicle;

import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.infra.persistence.vehicle.VehicleEntity;

public class VehicleMapper {
  public Vehicle toDomain(VehicleEntity vehicleEntity) {
    return new Vehicle(vehicleEntity.getId(), vehicleEntity.getMark(), vehicleEntity.getModel(), vehicleEntity.getColor(),  vehicleEntity.getPlate(), vehicleEntity.getTypeVehicle());
  }  

  public VehicleEntity toEntity(Vehicle vehicle) {
    return new VehicleEntity(vehicle.getId(), vehicle.getMark(), vehicle.getModel(), vehicle.getColor(), vehicle.getPlate(), vehicle.getTypeVehicle());
  }
}
