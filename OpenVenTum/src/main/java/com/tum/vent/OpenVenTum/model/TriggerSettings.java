package com.tum.vent.OpenVenTum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TriggerSettings {
    private @GeneratedValue
    @Id
    int triggerSettings_id;
    /**
     * %: Oxygen concentration of inspired air
     */
    private  float FiO2;
    /**
     * %: of inspired air
     */
    private  float humidity;
    /**
     * cmH2O: Maximum allowed peak pressure
     */
    private  float pressureMax;
    /**
     * cmH2O: Maximum allowed average pressure
     */
    private  float pressureMean;
    /**
     * mL per Minute
     */
    private  float MVe;
    /**
     *Breathes per minute
     */
    private  float RR;
    /**
     * mL: Tidal Volume
     */
    private  float VT;
    /**
     * cmH2O: Positive End Expiratory Pressure
     */
    private  float PEEP;
    /**
     * Inspiration to Expiration rate: 1.4 = 1 to 4
     */
    private  float IE;

    public TriggerSettings(float fiO2, float humidity, float pressureMax, float pressureMean, float MVe, float RR, float VT, float PEEP, float IE) {
        this.FiO2 = fiO2;
        this.humidity = humidity;
        this.pressureMax = pressureMax;
        this.pressureMean = pressureMean;
        this.MVe = MVe;
        this.RR = RR;
        this.VT = VT;
        this.PEEP = PEEP;
        this.IE = IE;
    }

    public int getTriggerSettings_id() {
        return triggerSettings_id;
    }

    public float getFiO2() {
        return FiO2;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressureMax() {
        return pressureMax;
    }

    public float getPressureMean() {
        return pressureMean;
    }

    public float getMVe() {
        return MVe;
    }

    public float getRR() {
        return RR;
    }

    public float getVT() {
        return VT;
    }

    public float getPEEP() {
        return PEEP;
    }

    public float getIE() {
        return IE;
    }

    public void setFiO2(float FiO2) {
        this.FiO2 = FiO2;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPressureMax(float pressureMax) {
        this.pressureMax = pressureMax;
    }

    public void setPressureMean(float pressureMean) {
        this.pressureMean = pressureMean;
    }

    public void setMVe(float MVe) {
        this.MVe = MVe;
    }

    public void setRR(float RR) {
        this.RR = RR;
    }

    public void setVT(float VT) {
        this.VT = VT;
    }

    public void setPEEP(float PEEP) {
        this.PEEP = PEEP;
    }

    public void setIE(float IE) {
        this.IE = IE;
    }

}
