package com.patrickaraujo.parking_management_challenge.core.models;

public class Vehicle {
  private String id;
  private String mark;
  private String model;
  private String color;
  private String plate;
  private VehicleType typeVehicle;
  private boolean isParked;

  public Vehicle(String mark, String model, String color, String plate, VehicleType typeVehicle, boolean isParked) {
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.plate = plate;
    this.typeVehicle = typeVehicle;
    this.isParked = isParked;
  }

  public Vehicle(String id, String mark, String model, String color, String plate, VehicleType typeVehicle, boolean isParked) {
    this.id = id;
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.plate = plate;
    this.typeVehicle = typeVehicle;
    this.isParked = isParked;
  }

  public Vehicle() {}

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public VehicleType getTypeVehicle() {
    return typeVehicle;
  }

  public void setTypeVehicle(VehicleType typeVehicle) {
    this.typeVehicle = typeVehicle;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isParked() {
    return isParked;
  }

  public void setParked(boolean isParked) {
    this.isParked = isParked;
  }

}
