package com.tum.vent.OpenVenTum.PythonUtils;

import org.junit.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Collections;

public class PythonRunnerTest {

    @Test
    public void readInfoForPatient() throws IOException, InterruptedException {
        String json = PythonRunner.readInfoForPatient("2");
        System.out.println(json);
        assertNotEmpty(json);
    }

    @Test
    public void clusterVents() throws IOException, InterruptedException {
        String json = PythonRunner.cluster_ventilators("4");
        System.out.println(json);
        assertNotEmpty(json);
    }

    @Test
    public void predict() throws IOException, InterruptedException {
        String json = PythonRunner.predict("10");
        System.out.println(json);
        assertNotEmpty(json);
    }

    private void assertNotEmpty(String json) {
        Assert.notNull(json, "JSON String is null.");
        Assert.notEmpty(Collections.singleton(json), "JSON String is empty.");
    }

    @Test
    public void create_doctor() throws IOException {
        String json = PythonRunner.create_doctor("1", "Ivan");
        System.out.println(json);
        assertNotEmpty(json);
    }
    @Test
    public void create_patient() throws IOException {
        String json = PythonRunner.create_patient("6", "Mishok", "10", "2", "\"mnogo e bolen\"");
        System.out.println(json);
        assertNotEmpty(json);
    }

    @Test
    public void retrieve_patients() throws IOException {
        String json = PythonRunner.retrieve_patients("10");
        System.out.println(json);
        assertNotEmpty(json);
    }
}
