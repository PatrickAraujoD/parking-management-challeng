package com.patrickaraujo.parking_management_challenge.application.establishment;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.EstablishmentNotFoundException;
import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.DeleteEstablishmentById;

public class DeleteEstablishmentByIdService implements DeleteEstablishmentById {
  private EstablishmentRepository establishmentRepository;

  public DeleteEstablishmentByIdService(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }

  @Override
  public void delete(String id) {
    Optional<Establishment> establishment = this.establishmentRepository.findById(id);
    if (!establishment.isPresent()) {
      throw new EstablishmentNotFoundException("Establishment not found with id: " + id);
    }
    this.establishmentRepository.deleteById(id);
  }
}
