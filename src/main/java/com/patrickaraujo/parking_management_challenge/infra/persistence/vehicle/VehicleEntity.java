package com.patrickaraujo.parking_management_challenge.infra.persistence.vehicle;

import com.patrickaraujo.parking_management_challenge.core.models.VehicleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "vehicles")
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class VehicleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String mark;
  private String model;
  private String color;
  private String plate;
  @Column(name = "vehicle_type")
  private VehicleType vehicleType;
  @Column(name = "is_parked")
  private boolean isParked;
}
