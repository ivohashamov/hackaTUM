package com.tum.vent.OpenVenTum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Patient{
    private @Id @NotNull
    @GeneratedValue
    Integer id;
    @NotNull
    private final String name;
    private final int doc_id;

    public Patient(String name, int doc_id){
        this.name = name;
        this.doc_id= doc_id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public int getDoc_id() {
        return doc_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return doc_id == patient.doc_id &&
                Objects.equals(id, patient.id) &&
                Objects.equals(name, patient.name);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doc_id=" + doc_id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, doc_id);
    }
}