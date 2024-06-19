package com.buildpcchecker.buildpcchecker.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingController {
    @Autowired
    IsettingService isettingService;

    @GetMapping("/test-setting")
    public String test(){
        return "test-setting";
    }
}
