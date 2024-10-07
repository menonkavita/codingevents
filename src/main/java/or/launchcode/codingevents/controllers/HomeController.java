package or.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// Accidentally typed in package name as 'or' instead of 'org'

@Controller
public class HomeController {

    @GetMapping()
    public String hello(){
        return "index";
    }

}
