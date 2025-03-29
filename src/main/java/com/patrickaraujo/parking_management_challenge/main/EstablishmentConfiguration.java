package com.patrickaraujo.parking_management_challenge.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.application.establishment.AddEstablishmentService;
import com.patrickaraujo.parking_management_challenge.application.establishment.UpdateEstablishmentService;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.AddEstablishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.UpdateEstablishment;
import com.patrickaraujo.parking_management_challenge.infra.gateways.address.AddressMapper;
import com.patrickaraujo.parking_management_challenge.infra.gateways.establishment.EstablishmentMapper;
import com.patrickaraujo.parking_management_challenge.infra.gateways.establishment.EstablishmentRepositoryGateway;
import com.patrickaraujo.parking_management_challenge.infra.persistence.establishment.EstablishmentRepositoryJpa;

@Configuration
public class EstablishmentConfiguration {
  @Bean
  public AddEstablishment addEstablishment(EstablishmentRepository establishmentRepository) {
    return new AddEstablishmentService(establishmentRepository);
  }

  @Bean
  public EstablishmentRepository establishmentRepository(EstablishmentRepositoryJpa establishmentRepositoryJpa, EstablishmentMapper establishmentMapper) {
    return new EstablishmentRepositoryGateway(establishmentRepositoryJpa, establishmentMapper);
  }

  @Bean
  public EstablishmentMapper establishmentMapper(AddressMapper addressMapper) {
    return new EstablishmentMapper(addressMapper);
  }

  @Bean
  public AddressMapper addressMapper() {
    return new AddressMapper();
  }

  @Bean
  public UpdateEstablishment updateEstablishment(EstablishmentRepository establishmentRepository) {
    return new UpdateEstablishmentService(establishmentRepository);
  }
}
