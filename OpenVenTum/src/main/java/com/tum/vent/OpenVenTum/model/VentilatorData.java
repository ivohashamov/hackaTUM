package com.tum.vent.OpenVenTum.model;

import javax.persistence.*;

@Entity
public class VentilatorData {
        private @GeneratedValue @Id
    int data_id;
        private int p_id;
        private int doc_id;
        private long time;
        private @OneToOne Processed processed;
        private @OneToOne Raw raw;
        private @ManyToOne Ventilator ventilator;

    public VentilatorData(int p_id, int doc_id, long time, Processed processed, Raw raw,Ventilator ventilator) {
        this.p_id = p_id;
        this.doc_id = doc_id;
        this.time = time;
        this.processed = processed;
        this.raw = raw;
        this.ventilator=ventilator;
    }

    public int getData_id() {
        return data_id;
    }

    public void setData_id(int data_id) {
        this.data_id = data_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public long getTime() {
        return time;
    }

    public Processed getProcessed() {
        return processed;
    }

    public void setProcessed(Processed processed) {
        this.processed = processed;
    }

    public Raw getRaw() {
        return raw;
    }

    public void setRaw(Raw raw) {
        this.raw = raw;
    }

    public Ventilator getVentilator() {
        return ventilator;
    }


    public void setVentilator(Ventilator ventilator) {
        this.ventilator = ventilator;
    }

}
