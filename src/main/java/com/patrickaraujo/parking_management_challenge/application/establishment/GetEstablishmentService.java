package com.patrickaraujo.parking_management_challenge.application.establishment;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.EstablishmentNotFoundException;
import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.GetEstablishmentById;

public class GetEstablishmentService implements GetEstablishmentById {
  private EstablishmentRepository establishmentRepository;

  public GetEstablishmentService(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }
  
  @Override
  public Establishment get(String id) {
    Optional<Establishment> establishment =  this.establishmentRepository.findById(id);
    if(!establishment.isPresent()) {
      throw new EstablishmentNotFoundException("Establishment not found with id: " + id);
    }
    return establishment.get();
  }
}
