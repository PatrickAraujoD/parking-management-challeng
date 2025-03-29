package com.patrickaraujo.parking_management_challenge.core.models;

public class Establishment {
  private String id;
  private String name;
  private String cnpj;
  private Address address;
  private String phone;
  private int number_of_spaces_motorcycles;
  private int number_of_spaces_cars;

  public Establishment(String id, String name, String cnpj, Address address, String phone,
      int number_of_spaces_motorcycles,
      int number_of_spaces_cars) {
    this.id = id;
    this.name = name;
    this.cnpj = cnpj;
    this.address = address;
    this.phone = phone;
    this.number_of_spaces_motorcycles = number_of_spaces_motorcycles;
    this.number_of_spaces_cars = number_of_spaces_cars;
  }

  public Establishment(String name, String cnpj, Address address, String phone, int number_of_spaces_motorcycles,
      int number_of_spaces_cars) {
    this.name = name;
    this.cnpj = cnpj;
    this.address = address;
    this.phone = phone;
    this.number_of_spaces_motorcycles = number_of_spaces_motorcycles;
    this.number_of_spaces_cars = number_of_spaces_cars;
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

  public int getNumber_of_spaces_motorcycles() {
    return number_of_spaces_motorcycles;
  }

  public void setNumber_of_spaces_motorcycles(int number_of_spaces_motorcycles) {
    this.number_of_spaces_motorcycles = number_of_spaces_motorcycles;
  }

  public int getNumber_of_spaces_cars() {
    return number_of_spaces_cars;
  }

  public void setNumber_of_spaces_cars(int number_of_spaces_cars) {
    this.number_of_spaces_cars = number_of_spaces_cars;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
