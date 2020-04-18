
CREATE TABLE doctors (
    doc_id int NOT NULL auto_increment,
    name varchar(200) NOT NULL,
    PRIMARY KEY (doc_id)

);

CREATE TABLE patients (
    p_id int NOT NULL auto_increment,
    name varchar(200) NOT NULL,
    doc_id int,
    PRIMARY KEY (p_id),
    FOREIGN KEY (doc_id) REFERENCES doctors(doc_id)
);

CREATE TABLE ventilators_data (
    data_id int NOT NULL auto_increment,
    p_id int NOT NULL,
    doc_id int NOT NULL,
    time float,
    volumePerMovement float,
    frequency float,
    volumePerMinute float,
    ventilationMode varchar(200),
    O2 float,
    CO2 float,
    humidity float,
    pressure float,
    pressure_mean float,
    mve float,
    RR float,
    VT float,
    PEEP float,
    pressure1 float,
    pressure2 float,
    temperature1 float,
    temperature2 float,
    CO2 float,
    O2 float,
    angleSensor float,
    current float,
    motorRPM float,
    PRIMARY KEY (data_id),
    FOREIGN KEY (p_id) REFERENCES patients(p_id),
    FOREIGN KEY (doc_id) REFERENCES doctors(doc_id)
);
