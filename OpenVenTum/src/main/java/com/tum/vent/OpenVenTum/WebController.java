package com.tum.vent.OpenVenTum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Controller
public class WebController extends WebMvcConfigurerAdapter {
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String showPage() {
        return "index";
    }
}
