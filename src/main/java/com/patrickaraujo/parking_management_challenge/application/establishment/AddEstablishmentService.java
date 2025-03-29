package com.patrickaraujo.parking_management_challenge.application.establishment;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.AlreadyExistsException;
import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.AddEstablishment;

public class AddEstablishmentService implements AddEstablishment {
  private EstablishmentRepository establishmentRepository;

  public AddEstablishmentService(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }

  @Override
  public Establishment add(Establishment establishment) {
    Establishment establishmentExists = this.establishmentRepository.findEstablishmentByCnpj(establishment.getCnpj());
    if (establishmentExists != null) {
      throw new AlreadyExistsException("Establishment already exists with CNPJ: " + establishmentExists.getCnpj());
    }
    return this.establishmentRepository.save(establishment);
  }
  
}
