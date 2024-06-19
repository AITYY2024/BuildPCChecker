package com.buildpcchecker.buildpcchecker.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @Autowired
    IusersService iusersService;



    @GetMapping("/test-login")
    public String login(){
        return "test-login";
    }



}
