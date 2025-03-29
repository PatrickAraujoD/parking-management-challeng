package com.patrickaraujo.parking_management_challenge.infra.persistence.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
  private String road;
  private int number;
  private String complement;
  private String city;
  private String state;
  private String cep;
}
