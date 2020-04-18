package com.tum.vent.OpenVenTum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Patient{
    private @Id @NotNull
    @GeneratedValue
    Integer id;
    @NotNull
    private final String name;
    private @ManyToOne Doctor doctor;
    private String notes;

    public Patient(String name, Doctor doctor){
        this.name = name;
        this.doctor= doctor;
        this.notes="";
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return this.doctor.getId() == patient.doctor.getId() &&
                Objects.equals(id, patient.id) &&
                Objects.equals(name, patient.name);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doc_id=" + doctor.getId() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, doctor);
    }
}