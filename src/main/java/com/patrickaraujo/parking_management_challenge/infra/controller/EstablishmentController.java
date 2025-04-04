package com.patrickaraujo.parking_management_challenge.infra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.AddEstablishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.DeleteEstablishmentById;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.GetEstablishmentById;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.UpdateEstablishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.VehicleEntryControl;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.VehicleExitControl;
import com.patrickaraujo.parking_management_challenge.infra.dtos.establishment.EstablishmentDTO;
import com.patrickaraujo.parking_management_challenge.infra.dtos.establishment.ManageVacanciesDTO;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {
  private final AddEstablishment addEstablishment;
  private final UpdateEstablishment updateEstablishment;
  private final GetEstablishmentById getEstablishmentById;
  private final DeleteEstablishmentById deleteEstablishmentById;
  private final VehicleEntryControl vehicleEntryControl;
  private final VehicleExitControl vehicleExitControl;

  public EstablishmentController(AddEstablishment addEstablishment, UpdateEstablishment updateEstablishment,
      GetEstablishmentById getEstablishmentById, DeleteEstablishmentById deleteEstablishmentById,
      VehicleEntryControl vehicleEntryControl, VehicleExitControl vehicleExitControl) {
    this.addEstablishment = addEstablishment;
    this.updateEstablishment = updateEstablishment;
    this.getEstablishmentById = getEstablishmentById;
    this.deleteEstablishmentById = deleteEstablishmentById;
    this.vehicleEntryControl = vehicleEntryControl;
    this.vehicleExitControl = vehicleExitControl;
  }

  @PostMapping
  public ResponseEntity<Void> createEstablishment(@RequestBody @Validated EstablishmentDTO data) {
    Establishment establishment = new Establishment(data.name(), data.cnpj(), data.address(), data.phone(),
        data.numberOfSpacesMotorcycles(), data.numberOfSpacesCars());
    addEstablishment.add(establishment);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Void> updateEstablishment(@RequestBody @Validated EstablishmentDTO data) throws Exception {
    this.updateEstablishment.update(data.id(), data.name(), data.address(), data.phone(),
        data.numberOfSpacesMotorcycles(), data.numberOfSpacesCars());
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Establishment> getEstablishmentEntityById(@PathVariable String id) {
    Establishment establishment = this.getEstablishmentById.get(id);
    return ResponseEntity.ok().body(establishment);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEstablishment(@PathVariable String id) {
    this.deleteEstablishmentById.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/vehicle-entry")
  public ResponseEntity<String> manageVacancies(@RequestBody ManageVacanciesDTO data) {
    String response = this.vehicleEntryControl.control(data.idEstablishment(), data.idVehicle());
    return ResponseEntity.ok().body(response);
  }

  @PutMapping("/vehicle-exit")
  public ResponseEntity<String> manageVehicleDeparture(@RequestBody ManageVacanciesDTO data) {
    String response = this.vehicleExitControl.control(data.idEstablishment(), data.idVehicle());
    return ResponseEntity.ok().body(response);
  }
}
