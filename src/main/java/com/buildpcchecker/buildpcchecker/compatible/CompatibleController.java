package com.buildpcchecker.buildpcchecker.compatible;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CompatibleController {
    @Autowired
    IcompatibleService icompatibleService;


}
