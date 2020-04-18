package com.tum.vent.OpenVenTum.PythonUtils;

import org.junit.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Collections;

public class PythonRunnerTest {

    @Test
    public void readInfoForPatient() throws IOException, InterruptedException {
        String json = PythonRunner.readInfoForPatient("2");
        assertCorrectValues(json);
    }

    @Test
    public void clusterVents() throws IOException, InterruptedException {
        String json = PythonRunner.cluster_ventilators("4");
        assertCorrectValues(json);
    }

    @Test
    public void predict() throws IOException, InterruptedException {
        String json = PythonRunner.predict("10");
        System.out.println(json);
        assertCorrectValues(json);
    }

    private void assertCorrectValues(String json) {
        Assert.notNull(json, "JSON String is null.");
        Assert.notEmpty(Collections.singleton(json), "JSON String is empty.");
    }

}
