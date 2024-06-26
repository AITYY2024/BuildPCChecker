package com.buildpcchecker.buildpcchecker.compatible;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompatibleController {
    @Autowired
    CompatibleService icompatibleService;

    @GetMapping("/compatible") //http://localhost:8080/compatible
    public String compatible(){
        return "compatible";}

}
