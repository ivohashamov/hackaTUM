package com.tum.vent.OpenVenTum.PythonUtils.model;

public class PatientJson {
    private  int p_id;
    private  String name;
    private  int doc_id;
    private  int vent;


    public void setP_id(int p_id){
        this.p_id = p_id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDoc_id(int doc_id){
        this.doc_id = doc_id;
    }

    public void setVent(int vent){
        this.vent=vent;
    }

    public int getP_id() {
        return p_id;
    }

    public String getName() {
        return name;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public int getVent() {
        return vent;
    }
}
