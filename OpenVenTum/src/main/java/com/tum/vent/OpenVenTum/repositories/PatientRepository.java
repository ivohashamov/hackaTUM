package com.tum.vent.OpenVenTum.repositories;

import com.tum.vent.OpenVenTum.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
