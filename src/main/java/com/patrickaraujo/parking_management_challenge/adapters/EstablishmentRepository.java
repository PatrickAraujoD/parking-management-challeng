package com.patrickaraujo.parking_management_challenge.adapters;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.core.models.Establishment;

public interface EstablishmentRepository {
  Establishment findEstablishmentByCnpj(String cnpj);
  Establishment save(Establishment establishment);
  Optional<Establishment> findById(String id);
  void deleteById(String id);
}
