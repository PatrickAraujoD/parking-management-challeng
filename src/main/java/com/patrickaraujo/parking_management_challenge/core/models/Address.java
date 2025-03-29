package com.patrickaraujo.parking_management_challenge.core.models;

public class Address {
  private String road;
  private int number;
  private String complement;
  private String city;
  private String state;
  private String cep;

  public Address(String road, int number, String complement, String city, String state, String cep) {
    this.road = road;
    this.number = number;
    this.complement = complement;
    this.city = city;
    this.state = state;
    this.cep = cep;
  }

  public String getRoad() {
    return road;
  }

  public void setRoad(String road) {
    this.road = road;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
