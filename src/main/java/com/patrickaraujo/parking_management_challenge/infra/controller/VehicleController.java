package com.patrickaraujo.parking_management_challenge.infra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.AddVehicle;
import com.patrickaraujo.parking_management_challenge.infra.dtos.vehicle.VehicleDTO;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
  private AddVehicle addVehicle;

  public VehicleController(AddVehicle addVehicle) {
    this.addVehicle = addVehicle;
  }

  @PostMapping
  public ResponseEntity<Void> createVehicle(@RequestBody VehicleDTO data) {
    Vehicle newVehicle = new Vehicle(data.mark(), data.model(), data.color(), data.plate(), data.vehicleType());
    this.addVehicle.add(newVehicle);
    return ResponseEntity.ok().build();
  }
}
