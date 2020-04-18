package com.tum.vent.OpenVenTum.PythonUtils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tum.vent.OpenVenTum.PythonUtils.model.VentilatorDataJson;

public class Deserializer {
    private final ObjectMapper mapper;

    public Deserializer(ObjectMapper mapper){
        this.mapper = mapper;
    }

    public VentilatorDataJson deserializeVentilatorData(String jsonString) throws JsonProcessingException {
        VentilatorDataJson ventdata= mapper.readValue(jsonString, VentilatorDataJson.class);
        return ventdata;
    }
    public VentilatorDataJson[] deserializeVentilatorDataArr(String jsonString) throws JsonProcessingException {
        VentilatorDataJson ventdata[]= mapper.readValue(jsonString, VentilatorDataJson[].class);
        return ventdata;
    }
}
