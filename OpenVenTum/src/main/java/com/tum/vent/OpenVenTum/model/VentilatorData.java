package com.tum.vent.OpenVenTum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VentilatorData {
        private @GeneratedValue @Id
    int data_id;
        private int p_id;
        private int doc_id;
        private  long time;
        private Processed processed;
        private Raw raw;

    public VentilatorData(int p_id, int doc_id, long time, Processed processed, Raw raw) {
        this.p_id = p_id;
        this.doc_id = doc_id;
        this.time = time;
        this.processed = processed;
        this.raw = raw;
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

    private enum VentilationMode{
        ASSIST_CONTROL, PRESSURE_CONTROL, VOLUME_CONTROL, FLOWRATE_CONTROL;
    }
    private class Processed{
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
        private  VentilationMode ventilationMode;
        /**
         *  %: concentration of expired O2
         */
        private  float expiredO2;
        /**
         * %: concentration of expired CO2
         */
        private  float expiredCO2;

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

        private TriggerSettings triggerSettings;
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


        private class TriggerSettings{
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
    }
    private class Raw {
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
}
