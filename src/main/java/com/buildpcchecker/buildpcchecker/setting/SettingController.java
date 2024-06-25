package com.buildpcchecker.buildpcchecker.setting;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingController {
    @Autowired
    IsettingService isettingService;

    @Autowired
    public HttpSession session;

    @GetMapping("/setting") //http://localhost:8080/setting
    public String setting(){
        return "setting";
    }

    @GetMapping("/login-redirect")
    public String redirect(){
        session.invalidate();
        return "login-redirect";}
}

