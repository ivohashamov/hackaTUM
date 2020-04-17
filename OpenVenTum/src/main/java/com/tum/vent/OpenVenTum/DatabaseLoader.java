package com.tum.vent.OpenVenTum;

import com.tum.vent.OpenVenTum.model.Doctor;
import com.tum.vent.OpenVenTum.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final DoctorRepository repository;

    @Autowired
    public DatabaseLoader(DoctorRepository rep){
        this.repository = rep;
    }
    @Override
    public void run(String... args) throws Exception {
        //request all patients from the database
        this.repository.save(new Doctor(args[0]));
    }
}
