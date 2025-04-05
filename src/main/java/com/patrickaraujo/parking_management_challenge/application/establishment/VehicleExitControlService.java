package com.patrickaraujo.parking_management_challenge.application.establishment;

import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.models.Vehicle;
import com.patrickaraujo.parking_management_challenge.core.models.VehicleType;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.GetEstablishmentById;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.VehicleExitControl;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.GetVehicleById;
import com.patrickaraujo.parking_management_challenge.core.usecases.vehicles.UpdateParkingStatus;

public class VehicleExitControlService implements VehicleExitControl {
  private final GetVehicleById getVehicleById;
  private final GetEstablishmentById getEstablishmentById;
  private final UpdateParkingStatus updateParkingStatus;

  public VehicleExitControlService(GetVehicleById getVehicleById,
      GetEstablishmentById getEstablishmentById, UpdateParkingStatus updateParkingStatus) {
    this.getVehicleById = getVehicleById;
    this.getEstablishmentById = getEstablishmentById;
    this.updateParkingStatus = updateParkingStatus;
  }

  @Override
  public String control(String idEstablishment, String idVehicle) {
    Establishment establishment = this.getEstablishmentById.get(idEstablishment);
    Vehicle vehicle = this.getVehicleById.get(idVehicle);
    if (vehicle.getTypeVehicle() == VehicleType.CAR) {
      establishment.setNumberOfSpacesCars(establishment.getNumberOfSpacesCars() + 1);
    } else {
      establishment.setNumberOfSpacesMotorcycles(establishment.getNumberOfSpacesMotorcycles() + 1);
    }
    this.updateParkingStatus.markAsParked(vehicle, false);
    return "Vehicle successfully exited";
  }
}
