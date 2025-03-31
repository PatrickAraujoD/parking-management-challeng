package com.patrickaraujo.parking_management_challenge.core.models;

public class Establishment {
  private String id;
  private String name;
  private String cnpj;
  private Address address;
  private String phone;
  private int numberOfSpacesMotorcycles;
  private int numberOfSpacesCars;

  public Establishment(String id, String name, String cnpj, Address address, String phone,
      int numberOfSpacesMotorcycles,
      int numberOfSpacesCars) {
    this.id = id;
    this.name = name;
    this.cnpj = cnpj;
    this.address = address;
    this.phone = phone;
    this.numberOfSpacesMotorcycles = numberOfSpacesMotorcycles;
    this.numberOfSpacesCars = numberOfSpacesCars;
  }

  public Establishment(String name, String cnpj, Address address, String phone, int numberOfSpacesMotorcycles,
      int numberOfSpacesCars) {
    this.name = name;
    this.cnpj = cnpj;
    this.address = address;
    this.phone = phone;
    this.numberOfSpacesMotorcycles = numberOfSpacesMotorcycles;
    this.numberOfSpacesCars = numberOfSpacesCars;
  }

  public Establishment() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getNumberOfSpacesMotorcycles() {
    return this.numberOfSpacesMotorcycles;
  }

  public void setNumberOfSpacesMotorcycles(int numberOfSpacesMotorcycles) {
    this.numberOfSpacesMotorcycles = numberOfSpacesMotorcycles;
  }

  public int getNumberOfSpacesCars() {
    return numberOfSpacesCars;
  }

  public void setNumberOfSpacesCars(int numberOfSpacesCars) {
    this.numberOfSpacesCars = numberOfSpacesCars;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
