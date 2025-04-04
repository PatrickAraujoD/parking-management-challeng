package com.patrickaraujo.parking_management_challenge.infra.gateways.establishment;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.infra.persistence.establishment.EstablishmentEntity;
import com.patrickaraujo.parking_management_challenge.infra.persistence.establishment.EstablishmentRepositoryJpa;

public class EstablishmentRepositoryGateway implements EstablishmentRepository {
  private EstablishmentRepositoryJpa establishmentRepositoryJpa;
  private EstablishmentMapper establishmentMapper;

  public EstablishmentRepositoryGateway(EstablishmentRepositoryJpa establishmentRepositoryJpa,
      EstablishmentMapper establishmentMapper) {
    this.establishmentRepositoryJpa = establishmentRepositoryJpa;
    this.establishmentMapper = establishmentMapper;
  }

  @Override
  public Establishment findEstablishmentByCnpj(String cnpj) {
    EstablishmentEntity establishmentEntity = this.establishmentRepositoryJpa.findByCnpj(cnpj);
    if (establishmentEntity == null) {
      return null;
    }
    return this.establishmentMapper.toDomain(establishmentEntity);
  }

  @Override
  public Establishment save(Establishment establishment) {
    EstablishmentEntity establishmentEntity = this.establishmentMapper.toEntity(establishment);
    return this.establishmentMapper.toDomain(this.establishmentRepositoryJpa.save(establishmentEntity));
  }

  @Override
  public Optional<Establishment> findById(String id) {
    Optional<EstablishmentEntity> establishmentEntity = this.establishmentRepositoryJpa.findById(id);
    if (establishmentEntity.isPresent()) {
      return Optional.of(this.establishmentMapper.toDomain(establishmentEntity.get()));
    }
    return Optional.empty();
  }

  @Override
  public void deleteById(String id) {
    this.establishmentRepositoryJpa.deleteById(id);
  }
}
