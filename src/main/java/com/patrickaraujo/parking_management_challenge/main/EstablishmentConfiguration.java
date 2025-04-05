package com.patrickaraujo.parking_management_challenge.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.application.establishment.AddEstablishmentService;
import com.patrickaraujo.parking_management_challenge.application.establishment.DeleteEstablishmentByIdService;
import com.patrickaraujo.parking_management_challenge.application.establishment.GetEstablishmentService;
import com.patrickaraujo.parking_management_challenge.application.establishment.UpdateEstablishmentService;
import com.patrickaraujo.parking_management_challenge.application.establishment.VehicleEntryControlService;
import com.patrickaraujo.parking_management_challenge.application.establishment.VehicleExitControlService;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.AddEstablishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.DeleteEstablishmentById;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.GetEstablishmentById;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.UpdateEstablishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.VehicleEntryControl;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.VehicleExitControl;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.GetVehicleById;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateParkingStatus;
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
  public EstablishmentRepository establishmentRepository(EstablishmentRepositoryJpa establishmentRepositoryJpa,
      EstablishmentMapper establishmentMapper) {
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

  @Bean
  public VehicleEntryControl vehicleEntryControl(EstablishmentRepository establishmentRepository,
      GetEstablishmentById getEstablishmentById, GetVehicleById getVehicleById,
      UpdateParkingStatus updateParkingStatus) {
    return new VehicleEntryControlService(establishmentRepository,
        getEstablishmentById, getVehicleById,
        updateParkingStatus);
  }

  @Bean
  public VehicleExitControl vehicleExitControl(EstablishmentRepository establishmentRepository,
      GetEstablishmentById getEstablishmentById, GetVehicleById getVehicleById,
      UpdateParkingStatus updateParkingStatus) {
    return new VehicleExitControlService(getVehicleById, getEstablishmentById, updateParkingStatus,
        establishmentRepository);
  }

  @Bean
  public GetEstablishmentById getEstablishmentById(EstablishmentRepository establishmentRepository) {
    return new GetEstablishmentService(establishmentRepository);
  }

  @Bean
  public DeleteEstablishmentById deleteEstablishmentById(EstablishmentRepository establishmentRepository) {
    return new DeleteEstablishmentByIdService(establishmentRepository);
  }
}
