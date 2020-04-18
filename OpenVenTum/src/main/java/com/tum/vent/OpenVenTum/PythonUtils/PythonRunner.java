package com.tum.vent.OpenVenTum.PythonUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PythonRunner {

    private static String path = System.getProperty("user.dir");
    private    static String read_info_for_patient = "python3 "+ path + "\\scripts\\read_info\\read_info_for_patient.py --p_id ";
    private static String cluster_ventilators = "python3 "+path+ "\\scripts\\cluster\\cluster_ventilators.py --v ";
    private static String predict = "python3 " + path + "\\scripts\\predict_status\\predict.py --doc_id ";

    private static String runCommand(String command, String args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(command + args);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getErrorStream(), StandardCharsets.UTF_8));
        String s = null;
        String json = "";
        //int exitCode = p.waitFor();
        while ((s = br.readLine()) != null) {
            json += s + '\n';
        }
        while ((s = br1.readLine()) != null){
            System.out.println(s);
        }
        json = json.replace('\'', '"');
        return json;
    }
    public static String readInfoForPatient(String args) throws IOException, InterruptedException {
        String output = runCommand(read_info_for_patient, args);
        return output;
    }

    public static String cluster_ventilators(String args) throws IOException, InterruptedException {
        String output = runCommand(cluster_ventilators, args);
        return output;
    }

    public static String predict(String args) throws IOException, InterruptedException {
        String output = runCommand(predict, args);
        return output;
    }

}
