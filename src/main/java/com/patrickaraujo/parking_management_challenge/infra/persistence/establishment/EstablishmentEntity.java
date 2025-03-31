package com.patrickaraujo.parking_management_challenge.infra.persistence.establishment;

import com.patrickaraujo.parking_management_challenge.infra.persistence.address.AddressEntity;

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
  private AddressEntity address;
  private String phone;
  @Column(name = "number_of_spaces_motorcycles")
  private int numberOfSpacesMotorcycles;
  @Column(name = "number_of_spaces_cars")
  private int numberOfSpacesCars;

  public EstablishmentEntity(String name, AddressEntity address, String cnpj, String phone, int numberOfSpacesMotorcycles, int numberOfSpacesCars) {
    this.name = name;
    this.address = address;
    this.cnpj = cnpj;
    this.phone = phone;
    this.numberOfSpacesMotorcycles = numberOfSpacesMotorcycles;
    this.numberOfSpacesCars = numberOfSpacesCars;
  }
}
