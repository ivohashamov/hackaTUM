package com.tum.vent.OpenVenTum.PythonUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PythonRunner {

    private static final String path = System.getProperty("user.dir");
    private static final String read_info_for_patient = "python "+ path + "\\scripts\\read_info\\read_info_for_patient.py --p_id ";
    private static final String cluster_ventilators = "python "+path+ "\\scripts\\cluster\\cluster_ventilators.py --v ";
    private static final String predict = "python " + path + "\\scripts\\predict_status\\predict.py --doc_id ";
    private static final String create_doctor = "python " + path +"\\scripts\\create_db\\create_doctor.py --doc_id ";
    private static final String create_patient = "python " + path + "\\scripts\\create_db\\create_patient.py --p_id ";
    private static final String create_db_api = "python " + path + "\\scripts\\create_db\\create_db_api.py ";
    private static final String retrieve_patients = "python " + path + "\\scripts\\read_info\\retrieve_patients.py --doc_id ";


    private static String runCommand(String command, String... args) throws IOException {
        String arg = "";
        for (String a : args)
            arg +=a+ " ";

        Process p = Runtime.getRuntime().exec(command + arg);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getErrorStream(), StandardCharsets.UTF_8));
        String s;
        String json = "";
        //int exitCode = p.waitFor();
        while ((s = br.readLine()) != null) {
            json += s + '\n';
        }
        // Tva trqbva da loggva v edin moment vmesto da printva
        while ((s = br1.readLine()) != null){
            json += s + "\n";
            System.out.println(s);
        }
        json = json.replace('\'', '"');
        return json;
    }
    public static String readInfoForPatient(String args) throws IOException {
        String output = runCommand(read_info_for_patient, args);
        return output;
    }

    public static String cluster_ventilators(String args) throws IOException {
        String output = runCommand(cluster_ventilators, args);
        return output;
    }

    public static String predict(String args) throws IOException {
        String output = runCommand(predict, args);
        return output;
    }


    /**
     *
     * @param args args0 - doc_id, args1 - Name.
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static String create_doctor(String... args) throws IOException{
        String output = runCommand(create_doctor,args[0], " --name ",args[1]);
        return output;
    }

    /**
     *
     */
    public static String create_patient(String... args) throws IOException {
        String output = runCommand(create_patient, args[0], "--name", args[1],"--doc_id",args[2],"--vent",args[3],
                "--notes", args[4]);
        return output;
    }

    /**
     *
     */
    public static String create_db_api() throws IOException {
        String output = runCommand(create_db_api);
        return output;
    }

    public static String retrieve_patients(String doc_id)throws IOException{
        String output = runCommand(retrieve_patients, doc_id);
        return output;
    }

}
