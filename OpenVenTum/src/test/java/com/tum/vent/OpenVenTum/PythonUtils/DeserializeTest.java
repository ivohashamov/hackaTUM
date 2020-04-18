package com.tum.vent.OpenVenTum.PythonUtils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tum.vent.OpenVenTum.PythonUtils.json.Deserializer;
import com.tum.vent.OpenVenTum.PythonUtils.model.VentilatorDataJson;
import com.tum.vent.OpenVenTum.PythonUtils.model.Patient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

public class DeserializeTest {
    private String json;
    private String jsonArray;
    private Deserializer des;
    @Before
    public void pre() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("appdata.json");
        byte[] bytes = is.readAllBytes();
        json = new String(bytes);

         is = getClass().getClassLoader().getResourceAsStream("appDataArray.json");
         bytes = is.readAllBytes();
        jsonArray = new String(bytes);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        des = new Deserializer(mapper);
    }

    @Test
    public void deserialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        VentilatorDataJson ventData = mapper.readValue(json, VentilatorDataJson.class);
        assertionSet(ventData);
    }

    @Test
    public void deserializeWithClass() throws JsonProcessingException {
       VentilatorDataJson ventData =  des.deserializeVentilatorData(json);
       assertionSet(ventData);
    }
    private void assertionSet(VentilatorDataJson ventData){
        Assert.notNull(ventData, "Object was null.");
        Assert.notNull(ventData.getAnglesensor());
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
    public void deserializeJsonArray() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        VentilatorDataJson[] jsons = mapper.readValue(jsonArray, VentilatorDataJson[].class);
        for (VentilatorDataJson json : jsons)
            assertionSet(json);
    }
    @Test
    public void deserializeJsonArray2() throws JsonProcessingException {
        VentilatorDataJson[] jsons = des.deserializeVentilatorDataArr(jsonArray);
        for (VentilatorDataJson json : jsons)
            assertionSet(json);
    }

    @Test
    public void readInfoForPatientDeserialize() throws IOException, InterruptedException {
        String jsonArr = PythonRunner.readInfoForPatient( "2");
        VentilatorDataJson[] jsons = des.deserializeVentilatorDataArr(jsonArr);
        for (VentilatorDataJson json : jsons)
            assertionSet(json);
    }

    @Test
    public void retrievePatientsAndDeserialize() throws IOException {
        String jsonArr = PythonRunner.retrieve_patients("10");
        Patient[] patients = des.deserializePatientArray(jsonArr);
    }
}
