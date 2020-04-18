package com.tum.vent.OpenVenTum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Raw {
    private @GeneratedValue
    @Id
    int raw_id;
    /**
     * cmH2O: Pressure censor 1.
     */
    private final float pressure1;
    /**
     * cmH2O: Pressure Sensor 2
     */
    private final float pressure2;
    private final float temperature1; // Celsius
    private final float temperature2;// Celsius
    private final int CO2;// Concentration expired CO2.
    private final int O2;// Concentration expired O2.
    private final int angleCensor; // degrees
    private final float current; // ampers
    private final int motorRPM; // rounds per minute

    public Raw(float pressure1, float pressure2, float temperature1, float temperature2, int CO2, int o2,
               int angleCensor, float current, int motorRPM) {
        this.pressure1 = pressure1;
        this.pressure2 = pressure2;
        this.temperature1 = temperature1;
        this.temperature2 = temperature2;
        this.CO2 = CO2;
        O2 = o2;
        this.angleCensor = angleCensor;
        this.current = current;
        this.motorRPM = motorRPM;
    }

    public int getRaw_id() {
        return raw_id;
    }

    public float getPressure1() {
        return pressure1;
    }

    public float getPressure2() {
        return pressure2;
    }

    public float getTemperature1() {
        return temperature1;
    }

    public float getTemperature2() {
        return temperature2;
    }

    public int getCO2() {
        return CO2;
    }

    public int getO2() {
        return O2;
    }

    public int getAngleCensor() {
        return angleCensor;
    }

    public float getCurrent() {
        return current;
    }

    public int getMotorRPM() {
        return motorRPM;
    }
}
