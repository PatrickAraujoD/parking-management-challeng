package com.patrickaraujo.parking_management_challenge.infra.persistence.vehicle;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepositoryJpa extends JpaRepository<VehicleEntity, String> {
  Optional<VehicleEntity> findByPlate(String plate);
}
