package com.tum.vent.OpenVenTum.PythonUtils.model;


//@JsonDeserialize(using = DataDeserializer.class)
public class VentilatorDataJson {
    private String data_id;
    private int device_id;
    private float ExpiredCO2;
    private float ExpiredO2;
    private float MVe;
    private float flowrate;
    private float frequency;
    private float pressure;
    private float FiO2;
    private float IE;
    private float PEEP;
    private float RR;
    private float VT;
    private float humidity;
    private float pressure_max;
    private String ventilationMode;
    private float volumePerMinute;
    private float volumePerMovement;
    private float CO2;
    private float O2;
    private float angleSensor;
    private float current;
    private float motorRPM;
    private float pressure1;
    private float pressure2;
    private float temperature1;
    private float temperature2;
    private long time;


    // Getter Methods

    public String getData_id() {
        return data_id;
    }

    public int getDevice_id() {
        return device_id;
    }

    public float getExpiredCO2() {
        return ExpiredCO2;
    }

    public float getExpiredO2() {
        return ExpiredO2;
    }

    public float getMVe() {
        return MVe;
    }

    public float getFlowrate() {
        return flowrate;
    }

    public float getFrequency() {
        return frequency;
    }

    public float getPressure() {
        return pressure;
    }

    public float getFiO2() {
        return FiO2;
    }

    public float getIE() {
        return IE;
    }

    public float getPEEP() {
        return PEEP;
    }

    public float getRR() {
        return RR;
    }

    public float getVT() {
        return VT;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure_max() {
        return pressure_max;
    }

    public String getVentilationMode() {
        return ventilationMode;
    }

    public float getVolumePerMinute() {
        return volumePerMinute;
    }

    public float getVolumePerMovement() {
        return volumePerMovement;
    }

    public float getCO2() {
        return CO2;
    }

    public float getO2() {
        return O2;
    }

    public float getAngleSensor() {
        return angleSensor;
    }

    public float getCurrent() {
        return current;
    }

    public float getMotorRPM() {
        return motorRPM;
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

    public float getTime() {
        return time;
    }

    // Setter Methods

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public void setExpiredCO2(float ExpiredCO2) {
        this.ExpiredCO2 = ExpiredCO2;
    }

    public void setExpiredO2(float ExpiredO2) {
        this.ExpiredO2 = ExpiredO2;
    }

    public void setMVe(float MVe) {
        this.MVe = MVe;
    }

    public void setFlowrate(float flowrate) {
        this.flowrate = flowrate;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setFiO2(float FiO2) {
        this.FiO2 = FiO2;
    }

    public void setIE(float IE) {
        this.IE = IE;
    }

    public void setPEEP(float PEEP) {
        this.PEEP = PEEP;
    }

    public void setRR(float RR) {
        this.RR = RR;
    }

    public void setVT(float VT) {
        this.VT = VT;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPressure_max(float pressure_max) {
        this.pressure_max = pressure_max;
    }

    public void setVentilationMode(String ventilationMode) {
        this.ventilationMode = ventilationMode;
    }

    public void setVolumePerMinute(float volumePerMinute) {
        this.volumePerMinute = volumePerMinute;
    }

    public void setVolumePerMovement(float volumePerMovement) {
        this.volumePerMovement = volumePerMovement;
    }

    public void setCO2(float CO2) {
        this.CO2 = CO2;
    }

    public void setO2(float O2) {
        this.O2 = O2;
    }

    public void setAngleSensor(float angleSensor) {
        this.angleSensor = angleSensor;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public void setMotorRPM(float motorRPM) {
        this.motorRPM = motorRPM;
    }

    public void setPressure1(float pressure1) {
        this.pressure1 = pressure1;
    }

    public void setPressure2(float pressure2) {
        this.pressure2 = pressure2;
    }

    public void setTemperature1(float temperature1) {
        this.temperature1 = temperature1;
    }

    public void setTemperature2(float temperature2) {
        this.temperature2 = temperature2;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
