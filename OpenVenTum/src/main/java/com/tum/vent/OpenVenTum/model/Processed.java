package com.tum.vent.OpenVenTum.model;

import javax.persistence.*;

@Entity
public class Processed {
    private @GeneratedValue
    @Id
    int processed_id;
    /**
     * total inspired volume per breath cycle
     */
    private float volumePerMovement;
    /**
     * Breathes per minute: patients number of breathes per minute
     */
    private  float frequency;
    /**
     *  mL: total inspired air over one minute
     */
    private  float MVe;
    /**
     * Type of the control e.g: Assist Control/ Pressure Control/ Volume Control/ Flowrate Control
     */
    @Enumerated(EnumType.ORDINAL)
    private VentilationMode ventilationMode;
    /**
     *  %: concentration of expired O2
     */
    private  float expiredO2;
    /**
     * %: concentration of expired CO2
     */
    private  float expiredCO2;

    public Processed(float volumePerMovement, float frequency, float MVe, VentilationMode ventilationMode, float expiredO2, float expiredCO2, TriggerSettings triggerSettings) {
        this.volumePerMovement = volumePerMovement;
        this.frequency = frequency;
        this.MVe = MVe;
        this.ventilationMode = ventilationMode;
        this.expiredO2 = expiredO2;
        this.expiredCO2 = expiredCO2;
        this.triggerSettings = triggerSettings;
    }

    public int getProcessed_id() {
        return processed_id;
    }

    public float getVolumePerMovement() {
        return volumePerMovement;
    }

    public float getFrequency() {
        return frequency;
    }

    public float getMVe() {
        return MVe;
    }

    public VentilationMode getVentilationMode() {
        return ventilationMode;
    }

    public float getExpiredO2() {
        return expiredO2;
    }

    public float getExpiredCO2() {
        return expiredCO2;
    }

    public TriggerSettings getTriggerSettings() {
        return triggerSettings;
    }

    private @OneToOne TriggerSettings triggerSettings;
    public void setVolumePerMovement(float volumePerMovement) {
        this.volumePerMovement = volumePerMovement;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public void setMVe(float MVe) {
        this.MVe = MVe;
    }

    public void setVentilationMode(VentilationMode ventilationMode) {
        this.ventilationMode = ventilationMode;
    }

    public void setExpiredCO2(float ExpiredCO2) {
        this.expiredCO2 = ExpiredCO2;
    }

    public void setExpiredO2(float ExpiredO2) {
        this.expiredO2 = ExpiredO2;
    }

    public void setTriggerSettings(TriggerSettings triggerSettings) {
        this.triggerSettings = triggerSettings;
    }
}
