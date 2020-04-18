package com.tum.vent.OpenVenTum;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tum.vent.OpenVenTum.PythonUtils.PythonRunner;
import com.tum.vent.OpenVenTum.PythonUtils.json.Deserializer;
import com.tum.vent.OpenVenTum.PythonUtils.model.PatientJson;
import com.tum.vent.OpenVenTum.model.Doctor;
import com.tum.vent.OpenVenTum.model.Patient;
import com.tum.vent.OpenVenTum.repositories.DoctorRepository;
import com.tum.vent.OpenVenTum.repositories.PatientRepository;
import com.tum.vent.OpenVenTum.repositories.VentilatorDataRepository;
import com.tum.vent.OpenVenTum.repositories.VentilatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final PatientRepository patientRepository;
    private final VentilatorRepository ventilatorRepository;
    private final VentilatorDataRepository ventilatorDataRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public DatabaseLoader(PatientRepository patientRepository, VentilatorRepository ventilatorRepository,
                          VentilatorDataRepository ventilatorDataRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.ventilatorRepository = ventilatorRepository;
        this.ventilatorDataRepository = ventilatorDataRepository;
        this.doctorRepository = doctorRepository;
    }

    
    

    @Override
    public void run(String... args) throws Exception {
        Deserializer deserializer=new Deserializer(new ObjectMapper());
        PatientJson[] arr =deserializer.deserializePatientArray(PythonRunner.retrieve_patients("10"));
        for (PatientJson pj: arr) {
            patientRepository.save(new Patient(pj.getName(),new Doctor("asdasd")));
        }
    }
}
