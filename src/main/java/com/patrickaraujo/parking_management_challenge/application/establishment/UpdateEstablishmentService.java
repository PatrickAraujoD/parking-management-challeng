package com.patrickaraujo.parking_management_challenge.application.establishment;

import com.patrickaraujo.parking_management_challenge.adapters.EstablishmentRepository;
import com.patrickaraujo.parking_management_challenge.core.exceptions.EstablishmentNotFoundException;
import com.patrickaraujo.parking_management_challenge.core.models.Address;
import com.patrickaraujo.parking_management_challenge.core.models.Establishment;
import com.patrickaraujo.parking_management_challenge.core.usecases.establishment.UpdateEstablishment;

import java.lang.reflect.Field;
import java.util.Optional;

public class UpdateEstablishmentService implements UpdateEstablishment {
  private EstablishmentRepository establishmentRepository;

  public UpdateEstablishmentService(EstablishmentRepository establishmentRepository) {
    this.establishmentRepository = establishmentRepository;
  }

  @Override
  public void update(String id, String cnpj, String name, Address address, String phone,
      Integer numberOfSpaceMotorcycles,
      Integer numberOfSpaceCars) throws Exception {
    Optional<Establishment> establishmentExists = this.establishmentRepository.findById(id);
    if (establishmentExists.isEmpty()) {
      throw new EstablishmentNotFoundException("Establishment not found with id: " + id);
    }
    Establishment updatedEstablishment = new Establishment();
    updatedEstablishment.setName(name);
    updatedEstablishment.setCnpj(cnpj);
    updatedEstablishment.setAddress(address);
    updatedEstablishment.setPhone(phone);
    updatedEstablishment.setNumber_of_spaces_motorcycles(numberOfSpaceMotorcycles);
    updatedEstablishment.setNumber_of_spaces_cars(numberOfSpaceCars);
    this.copyNonNullFields(updatedEstablishment, establishmentExists.get());
    this.establishmentRepository.save(establishmentExists.get());
  }

  @Override
  public void copyNonNullFields(Establishment source, Establishment target) throws Exception {
    Field[] fields = Establishment.class.getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      if (field.get(source) != null) {
        field.set(target, field.get(source));
      }
    }
  }
}
