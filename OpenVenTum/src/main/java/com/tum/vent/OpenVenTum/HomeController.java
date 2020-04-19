package com.tum.vent.OpenVenTum;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tum.vent.OpenVenTum.PythonUtils.PythonRunner;
import com.tum.vent.OpenVenTum.PythonUtils.json.Deserializer;
import com.tum.vent.OpenVenTum.PythonUtils.model.VentilatorDataJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/data/{id}", method = GET)
    @ResponseBody
    public String getFoosBySimplePathWithPathVariable(@PathVariable("id") long id) throws IOException {
        Deserializer deserializer=new Deserializer(new ObjectMapper());
        String vent= PythonRunner.readInfoForPatient("" + id);
        return vent;
    }

}
