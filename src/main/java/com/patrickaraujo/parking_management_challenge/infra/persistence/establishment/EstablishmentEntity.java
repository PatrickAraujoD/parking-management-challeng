package com.patrickaraujo.parking_management_challenge.infra.persistence.establishment;

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

@Table(name = "establishment")
@Entity(name = "EstablishmentEntity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EstablishmentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
  private String cnpj;
  private String address;
  private String phone;
  private int number_of_spaces_motorcycles;
  private int number_of_spaces_cars;

  public EstablishmentEntity(String name, String address, String cnpj, String phone, int number_of_spaces_motorcycles, int number_of_spaces_cars) {
    this.name = name;
    this.address = address;
    this.cnpj = cnpj;
    this.phone = phone;
    this.number_of_spaces_motorcycles = number_of_spaces_motorcycles;
    this.number_of_spaces_cars = number_of_spaces_cars;
  }
}
