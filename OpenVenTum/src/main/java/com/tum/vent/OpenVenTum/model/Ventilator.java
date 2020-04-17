package com.tum.vent.OpenVenTum.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Ventilator {
    private @GeneratedValue
    @Id
    int vent_id;
    private int p_id;
    //TODO как да го напрайм тва бе втф
    private VentilatorData ventilatorData;

    public Ventilator(int p_id, VentilatorData ventilatorData) {
        this.p_id = p_id;
        this.ventilatorData = ventilatorData;
    }

    public int getVent_id() {
        return vent_id;
    }

    public void setVent_id(int vent_id) {
        this.vent_id = vent_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public VentilatorData getVentilatorData() {
        return ventilatorData;
    }

    public void setVentilatorData(VentilatorData ventilatorData) {
        this.ventilatorData = ventilatorData;
    }
}
