package com.tum.vent.OpenVenTum.PythonUtils;

import org.junit.Test;
import org.springframework.util.Assert;

import java.io.IOException;

public class PythonRunnerTest {

    @Test
    public  void runCommand() throws IOException, InterruptedException {
        String json = PythonRunner.runCommand("2");
        Assert.notNull(json);
    }

}
