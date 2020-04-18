package com.tum.vent.OpenVenTum;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tum.vent.OpenVenTum.PythonUtils.PythonRunner;
import com.tum.vent.OpenVenTum.PythonUtils.json.Deserializer;
import com.tum.vent.OpenVenTum.PythonUtils.model.PatientJson;
import com.tum.vent.OpenVenTum.model.Patient;
import com.tum.vent.OpenVenTum.repositories.PatientRepository;
import com.tum.vent.OpenVenTum.repositories.VentilatorDataRepository;
import com.tum.vent.OpenVenTum.repositories.VentilatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final PatientRepository patientRepository;
    private final VentilatorRepository ventilatorRepository;
    private final VentilatorDataRepository ventilatorDataRepository;

    @Autowired
    public DatabaseLoader(PatientRepository patientRepository, VentilatorRepository ventilatorRepository,
                          VentilatorDataRepository ventilatorDataRepository) {
        this.patientRepository = patientRepository;
        this.ventilatorRepository = ventilatorRepository;
        this.ventilatorDataRepository = ventilatorDataRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Deserializer deserializer=new Deserializer(new ObjectMapper());
        PatientJson[] arr =deserializer.deserializePatientArray(PythonRunner.retrieve_patients("10"));
        patientRepository.saveAll(Arrays.stream(arr).map(pj->new Patient(pj.getP_id(),pj.getName(),pj.getDoc_id())).collect(Collectors.toList()));

    }
}
