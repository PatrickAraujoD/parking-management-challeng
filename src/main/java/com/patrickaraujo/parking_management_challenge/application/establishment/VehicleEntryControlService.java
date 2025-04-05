package com.patrickaraujo.parking_management_challenge.application.establishment;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.VacanciesUnavailableException;
import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.GetEstablishmentById;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.VehicleEntryControl;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.GetVehicleById;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateParkingStatus;
import com.patrickaraujo.parking_management_challenge.core.models.VehicleType;

public class VehicleEntryControlService implements VehicleEntryControl {
  private final EstablishmentRepository establishmentRepository;
  private final GetEstablishmentById getEstablishmentById;
  private final GetVehicleById getVehicleById;
  private final UpdateParkingStatus updateParkingStatus;

  public VehicleEntryControlService(EstablishmentRepository establishmentRepository,
      GetEstablishmentById getEstablishmentById, GetVehicleById getVehicleById,
      UpdateParkingStatus updateParkingStatus) {
    this.establishmentRepository = establishmentRepository;
    this.getEstablishmentById = getEstablishmentById;
    this.getVehicleById = getVehicleById;
    this.updateParkingStatus = updateParkingStatus;
  }

  @Override
  public String control(String idEstablishment, String idVehicle) {
    Establishment establishment = this.getEstablishmentById.get(idEstablishment);
    Vehicle vehicle = this.getVehicleById.get(idVehicle);
    if (vehicle.getTypeVehicle() == VehicleType.CAR) {
      if (establishment.getNumberOfSpacesCars() <= 0) {
        throw new VacanciesUnavailableException("There are no available car spaces at the moment");
      }
      establishment.setNumberOfSpacesCars(establishment.getNumberOfSpacesCars() - 1);
    } else {
      if (establishment.getNumberOfSpacesMotorcycles() <= 0) {
        throw new VacanciesUnavailableException("There are no spaces available for motorcycles at the moment");
      }
      establishment
          .setNumberOfSpacesMotorcycles(establishment.getNumberOfSpacesMotorcycles() - 1);
    }
    this.updateParkingStatus.markAsParked(vehicle, true);
    this.establishmentRepository.save(establishment);
    return "Vehicle successfully parked";
  }
}
