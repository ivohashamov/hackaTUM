package com.tum.vent.OpenVenTum.PythonUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PythonRunner {

    private static String path = System.getProperty("user.dir");
private    static String command = "python3 "+ path + "\\scripts\\read_info\\read_info_for_patient.py --p_id ";

    public static String runCommand(String args) throws IOException, InterruptedException {
        command += args;
        command = command.replace("\\OpenVenTum", "");
        Process p = Runtime.getRuntime().exec(command);
        while (p.isAlive()) {}

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getErrorStream(), StandardCharsets.UTF_8));
        String s = null;
        String json = "";
        while ((s = br1.readLine()) != null) {
            System.out.println(s);
        }
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            json += s + '\n';
        }
        return s;
    }
}
