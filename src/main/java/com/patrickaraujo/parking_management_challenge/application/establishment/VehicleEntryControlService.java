package com.patrickaraujo.parking_management_challenge.application.establishment;

import java.util.Optional;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.adapters.VehicleRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.EstablishmentNotFoundException;
import com.patrickaraujo.parking_management_challenge.core.exceptions.VacanciesUnavailableException;
import com.patrickaraujo.parking_management_challenge.core.exceptions.VehicleIsParkedException;
import com.patrickaraujo.parking_management_challenge.core.exceptions.VehicleNotFoundException;
import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.VehicleEntryControl;
import com.patrickaraujo.parking_management_challenge.core.models.VehicleType;

public class VehicleEntryControlService implements VehicleEntryControl {
  private final EstablishmentRepository establishmentRepository;
  private final VehicleRepository vehicleRepository;

  public VehicleEntryControlService(EstablishmentRepository establishmentRepository,
      VehicleRepository vehicleRepository) {
    this.establishmentRepository = establishmentRepository;
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public String control(String idEstablishment, String idVehicle, Integer numberVacanciesOccupied) {
    Optional<Establishment> establishmentExists = this.establishmentRepository.findById(idEstablishment);
    Optional<Vehicle> vehicleExists = this.vehicleRepository.findById(idVehicle);
    if (establishmentExists.isEmpty()) {
      throw new EstablishmentNotFoundException("Establishment not found with id: " + idEstablishment);
    }
    if (vehicleExists.isEmpty()) {
      throw new VehicleNotFoundException("Vehicle not found with id: " + idVehicle);
    }
    Establishment establishment = establishmentExists.get();
    Vehicle vehicle = vehicleExists.get();
    if (vehicle.isParked()) {
      throw new VehicleIsParkedException("The reported vehicle is already parked");
    }
    if (vehicle.getTypeVehicle() == VehicleType.CAR) {
      if (establishment.getNumberOfSpacesCars() < numberVacanciesOccupied) {
        throw new VacanciesUnavailableException("There are no available car spaces at the moment");
      }
      establishment.setNumberOfSpacesCars(establishment.getNumberOfSpacesCars() - numberVacanciesOccupied);
    } else {
      if (establishment.getNumberOfSpacesMotorcycles() < numberVacanciesOccupied) {
        throw new VacanciesUnavailableException("There are no spaces available for motorcycles at the moment");
      }
      establishment
          .setNumberOfSpacesMotorcycles(establishment.getNumberOfSpacesMotorcycles() - numberVacanciesOccupied);
    }
    vehicle.setParked(true);
    this.establishmentRepository.save(establishment);
    this.vehicleRepository.save(vehicle);
    return "Vehicle successfully parked";
  }
}
