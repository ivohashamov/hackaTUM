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
    Integer id;
    @NotNull
    private  String name;
    private int doc_Id;
    private String notes;


    public Patient(){

    }
    public Patient(Integer id,String name,int doc_Id){
        this.id=id;
        this.name = name;
        this.doc_Id=doc_Id;
        this.notes="";
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }


    public int getDoc_Id() {
        return doc_Id;
    }

    public void setDoc_Id(int doc_Id) {
        this.doc_Id = doc_Id;
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
        return this.doc_Id == patient.getDoc_Id() &&
                Objects.equals(id, patient.id) &&
                Objects.equals(name, patient.name);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doc_id=" + doc_Id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, doc_Id);
    }
}