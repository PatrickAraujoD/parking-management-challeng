package com.patrickaraujo.parking_management_challenge.infra.dtos.vehicle;

import com.patrickaraujo.parking_management_challenge.core.models.VehicleType;

public record VehicleDTO(
    String id,
    String mark,
    String plate,
    String model,
    String color,
    VehicleType vehicleType,
    boolean isParked
) {
}
