package com.patrickaraujo.parking_management_challenge.infra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.AddEstablishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.UpdateEstablishment;
import com.patrickaraujo.parking_management_challenge.infra.dtos.establishment.EstablishmentDTO;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {
  private final AddEstablishment addEstablishment;
  private final UpdateEstablishment updateEstablishment;

  public EstablishmentController(AddEstablishment addEstablishment, UpdateEstablishment updateEstablishment) {
    this.addEstablishment = addEstablishment;
    this.updateEstablishment = updateEstablishment;
  }

  @PostMapping
  public ResponseEntity<Void> createEstablishment(@RequestBody @Validated EstablishmentDTO data) {
    Establishment establishment = new Establishment(data.name(), data.cnpj(), data.address(), data.phone(), data.numberOfSpacesMotorcycles(), data.numberOfSpacesCars());
    addEstablishment.add(establishment);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Void> updateEstablishment(@RequestBody @Validated EstablishmentDTO data) throws Exception {
    this.updateEstablishment.update(data.cnpj(), data.name(), data.address(), data.phone(), data.numberOfSpacesMotorcycles(), data.numberOfSpacesCars());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
