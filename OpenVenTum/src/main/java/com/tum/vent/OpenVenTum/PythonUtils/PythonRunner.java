package com.tum.vent.OpenVenTum.PythonUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PythonRunner {

    private static String path = System.getProperty("user.dir");
private    static String command = "python3 "+ path + "\\scripts\\read_info\\read_info_for_patient.py --p_id ";

    public static String runCommand(String args) throws IOException, InterruptedException {
        command += args;
        Process p = Runtime.getRuntime().exec(command);

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
        String s = null;
        String json = "";
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            json += s + '\n';
        }
        json = json.replace('\'', '"');
        return json;
    }
}
