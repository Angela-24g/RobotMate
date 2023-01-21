package com.project.robotmate.home.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class controller {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home() {return "index"; }

}
