package com.tum.vent.OpenVenTum.model;

import javax.persistence.*;

@Entity
public class Ventilator {
    private
    @Id
    int vent_id;
    private @OneToOne Patient patient;
    //TODO как да го напрайм тва бе втф
    ;

    public Ventilator(int vent_id,Patient patient) {
        this.vent_id=vent_id;
        this.patient = patient;
    }

    public int getVent_id() {
        return vent_id;
    }

    public void setVent_id(int vent_id) {
        this.vent_id = vent_id;
    }




}
