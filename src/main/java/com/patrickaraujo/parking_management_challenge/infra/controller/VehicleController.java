package com.patrickaraujo.parking_management_challenge.infra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.AddVehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateVehicle;
import com.patrickaraujo.parking_management_challenge.infra.dtos.vehicle.UpdateVehicleDTO;
import com.patrickaraujo.parking_management_challenge.infra.dtos.vehicle.VehicleDTO;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
  private AddVehicle addVehicle;
  private UpdateVehicle updateVehicle;

  public VehicleController(AddVehicle addVehicle, UpdateVehicle updateVehicle) {
    this.addVehicle = addVehicle;
    this.updateVehicle = updateVehicle;
  }

  @PostMapping
  public ResponseEntity<Void> createVehicle(@RequestBody VehicleDTO data) {
    Vehicle newVehicle = new Vehicle(data.mark(), data.model(), data.color(), data.plate(), data.vehicleType());
    this.addVehicle.add(newVehicle);
    return ResponseEntity.ok().build();
  }

  @PutMapping
  public ResponseEntity<Void> updateVehicle(@RequestBody UpdateVehicleDTO data) {
    this.updateVehicle.update(data.id(), data.color());
    return ResponseEntity.ok().build();
  }
}
