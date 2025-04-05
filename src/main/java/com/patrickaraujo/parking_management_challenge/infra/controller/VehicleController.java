package com.patrickaraujo.parking_management_challenge.infra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.AddVehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.DeleteVehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.GetVehicleById;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateVehicle;
import com.patrickaraujo.parking_management_challenge.infra.dtos.vehicle.UpdateVehicleDTO;
import com.patrickaraujo.parking_management_challenge.infra.dtos.vehicle.VehicleDTO;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
  private AddVehicle addVehicle;
  private UpdateVehicle updateVehicle;
  private DeleteVehicle deleteVehicle;
  private GetVehicleById getVehicleById;

  public VehicleController(AddVehicle addVehicle, UpdateVehicle updateVehicle, DeleteVehicle deleteVehicle,
      GetVehicleById getVehicleById) {
    this.addVehicle = addVehicle;
    this.updateVehicle = updateVehicle;
    this.deleteVehicle = deleteVehicle;
    this.getVehicleById = getVehicleById;
  }

  @PostMapping
  public ResponseEntity<Void> createVehicle(@RequestBody VehicleDTO data) {
    Vehicle newVehicle = new Vehicle(data.mark(), data.model(), data.color(), data.plate(), data.vehicleType(), data.isParked());
    this.addVehicle.add(newVehicle);
    return ResponseEntity.ok().build();
  }

  @PutMapping
  public ResponseEntity<Void> updateVehicle(@RequestBody UpdateVehicleDTO data) {
    this.updateVehicle.update(data.id(), data.color());
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteVehicle(@PathVariable String id) {
    this.deleteVehicle.delete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Vehicle> getVehicleById(@PathVariable String id) {
    Vehicle vehicle = this.getVehicleById.get(id);
    return ResponseEntity.ok(vehicle);
  }
}
