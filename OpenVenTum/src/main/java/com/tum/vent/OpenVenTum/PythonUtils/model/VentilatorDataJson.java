package com.tum.vent.OpenVenTum.PythonUtils.model;


//@JsonDeserialize(using = DataDeserializer.class)
public class VentilatorDataJson {
    private String data_id;
    private int device_id;
    private float expiredco2;
    private float expiredo2;
    private float mve;
    private float flowrate;
    private float frequency;
    private float pressure;
    private float fio2;
    private float ie;
    private float peep;
    private float rr;
    private float vt;
    private float humidity;
    private float pressure_max;
    private String ventilationmode;
    private float volumeperminute;
    private float volumepermovement;
    private float co2;
    private float o2;
    private float anglesensor;
    private float current;
    private float motorrpm;
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
        return expiredco2;
    }

    public float getExpiredO2() {
        return expiredo2;
    }

    public float getMVe() {
        return mve;
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
        return fio2;
    }

    public float getIE() {
        return ie;
    }

    public float getPEEP() {
        return peep;
    }

    public float getRR() {
        return rr;
    }

    public float getVT() {
        return vt;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure_max() {
        return pressure_max;
    }

    public String getVentilationmode() {
        return ventilationmode;
    }

    public float getVolumeperminute() {
        return volumeperminute;
    }

    public float getVolumepermovement() {
        return volumepermovement;
    }

    public float getCO2() {
        return co2;
    }

    public float getO2() {
        return o2;
    }

    public float getAnglesensor() {
        return anglesensor;
    }

    public float getCurrent() {
        return current;
    }

    public float getMotorRPM() {
        return motorrpm;
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
        this.expiredco2 = ExpiredCO2;
    }

    public void setExpiredO2(float ExpiredO2) {
        this.expiredo2 = ExpiredO2;
    }

    public void setMVe(float mve) {
        this.mve = mve;
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

    public void setFiO2(float fio2) {
        this.fio2 = fio2;
    }

    public void setIE(float ie) {
        this.ie = ie;
    }

    public void setPEEP(float peep) {
        this.peep = peep;
    }

    public void setRR(float rr) {
        this.rr = rr;
    }

    public void setVT(float vt) {
        this.vt = vt;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPressure_max(float pressure_max) {
        this.pressure_max = pressure_max;
    }

    public void setVentilationmode(String ventilationmode) {
        this.ventilationmode = ventilationmode;
    }

    public void setVolumeperminute(float volumeperminute) {
        this.volumeperminute = volumeperminute;
    }

    public void setVolumepermovement(float volumepermovement) {
        this.volumepermovement = volumepermovement;
    }

    public void setCO2(float co2) {
        this.co2 = co2;
    }

    public void setO2(float o2) {
        this.o2 = o2;
    }

    public void setAnglesensor(float anglesensor) {
        this.anglesensor = anglesensor;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public void setMotorRPM(float motorRPM) {
        this.motorrpm = motorRPM;
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
