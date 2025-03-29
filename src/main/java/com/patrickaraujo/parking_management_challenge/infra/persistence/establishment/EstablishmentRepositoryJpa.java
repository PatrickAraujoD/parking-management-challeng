package com.patrickaraujo.parking_management_challenge.infra.persistence.establishment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepositoryJpa extends JpaRepository<EstablishmentEntity, String> {
  EstablishmentEntity findByCnpj(String cnpj);
}
