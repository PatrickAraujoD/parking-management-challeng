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
import com.patrickaraujo.parking_management_challenge.infra.dtos.establishment.EstablishmentDTO;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {
  private final AddEstablishment addEstablishment;
  private final UpdateEstablishment updateEstablishment;
  private final GetEstablishmentById getEstablishmentById;
  private final DeleteEstablishmentById deleteEstablishmentById;

  public EstablishmentController(AddEstablishment addEstablishment, UpdateEstablishment updateEstablishment,
      GetEstablishmentById getEstablishmentById, DeleteEstablishmentById deleteEstablishmentById) {
    this.addEstablishment = addEstablishment;
    this.updateEstablishment = updateEstablishment;
    this.getEstablishmentById = getEstablishmentById;
    this.deleteEstablishmentById = deleteEstablishmentById;
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
  public ResponseEntity<Establishment> getEstaEntityById(@PathVariable String id) {
    Establishment establishment = this.getEstablishmentById.get(id);
    return ResponseEntity.ok().body(establishment);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEstablishment(@PathVariable String id) {
    this.deleteEstablishmentById.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
