package com.tum.vent.OpenVenTum.PythonUtils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tum.vent.OpenVenTum.PythonUtils.json.Deserializer;
import com.tum.vent.OpenVenTum.PythonUtils.model.VentilatorDataJson;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

public class DeserializeTest {
    private String json;
    @Before
    public void pre() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("appdata.json");
        byte[] bytes = is.readAllBytes();
        json = new String(bytes);
    }

    @Test
    public void deserialize() throws JsonProcessingException {
        VentilatorDataJson ventData = new ObjectMapper().readValue(json, VentilatorDataJson.class);
        Assert.notNull(ventData, "Object was null.");
        Assert.notNull(ventData.getAngleSensor());
        Assert.notNull(ventData.getCO2());
        Assert.notNull(ventData.getCurrent());
        Assert.notNull(ventData.getData_id());
        Assert.notNull(ventData.getDevice_id());
        Assert.notNull(ventData.getExpiredCO2());
        Assert.notNull(ventData.getExpiredO2());
        Assert.notNull(ventData.getFiO2());
        Assert.notNull(ventData.getFlowrate());
        Assert.notNull(ventData.getFrequency());
        Assert.notNull(ventData.getHumidity());
        Assert.notNull(ventData.getIE());
    }

    @Test
    public void deserializeWithClass() throws JsonProcessingException {
        Deserializer des = new Deserializer(new ObjectMapper());
       VentilatorDataJson ventData =  des.deserializeVentilatorData(json);
        Assert.notNull(ventData, "Object was null.");
        Assert.notNull(ventData.getAngleSensor());
        Assert.notNull(ventData.getCO2());
        Assert.notNull(ventData.getCurrent());
        Assert.notNull(ventData.getData_id());
        Assert.notNull(ventData.getDevice_id());
        Assert.notNull(ventData.getExpiredCO2());
        Assert.notNull(ventData.getExpiredO2());
        Assert.notNull(ventData.getFiO2());
        Assert.notNull(ventData.getFlowrate());
        Assert.notNull(ventData.getFrequency());
        Assert.notNull(ventData.getHumidity());
        Assert.notNull(ventData.getIE());
    }
}
