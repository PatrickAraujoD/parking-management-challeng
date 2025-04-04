package com.patrickaraujo.parking_management_challenge.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.patrickaraujo.parking_management_challenge.adapters.VehicleRepository;
import com.patrickaraujo.parking_management_challenge.application.vehicle.AddVehicleService;
import com.patrickaraujo.parking_management_challenge.application.vehicle.DeleteVehicleService;
import com.patrickaraujo.parking_management_challenge.application.vehicle.GetVehicleByIdService;
import com.patrickaraujo.parking_management_challenge.application.vehicle.UpdateParkingStatusService;
import com.patrickaraujo.parking_management_challenge.application.vehicle.UpdateVehicleService;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.AddVehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.DeleteVehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.GetVehicleById;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateParkingStatus;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateVehicle;
import com.patrickaraujo.parking_management_challenge.infra.gateways.vehicle.VehicleMapper;
import com.patrickaraujo.parking_management_challenge.infra.gateways.vehicle.VehicleRepositoryGateway;
import com.patrickaraujo.parking_management_challenge.infra.persistence.vehicle.VehicleRepositoryJpa;

@Configuration
public class VehicleConfiguration {
  @Bean
  public AddVehicle addVehicle(VehicleRepository vehicleRepository) {
    return new AddVehicleService(vehicleRepository);
  }

  @Bean
  public UpdateVehicle updateVehicle(VehicleRepository vehicleRepository) {
    return new UpdateVehicleService(vehicleRepository);
  }

  @Bean
  public GetVehicleById getVehicleById(VehicleRepository vehicleRepository) {
    return new GetVehicleByIdService(vehicleRepository);
  }

  @Bean
  public DeleteVehicle deleteVehicle(VehicleRepository vehicleRepository) {
    return new DeleteVehicleService(vehicleRepository);
  }

  @Bean
  public UpdateParkingStatus updateParkingStatus(VehicleRepository vehicleRepository) {
    return new UpdateParkingStatusService(vehicleRepository);
  }

  @Bean
  public VehicleRepository vehicleRepository(VehicleRepositoryJpa vehicleRepositoryJpa, VehicleMapper vehicleMapper) {
    return new VehicleRepositoryGateway(vehicleRepositoryJpa, vehicleMapper);
  }

  @Bean
  public VehicleMapper vehicleMapper() {
    return new VehicleMapper();
  }
}
