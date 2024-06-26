package com.buildpcchecker.buildpcchecker.login;

import com.buildpcchecker.buildpcchecker.date.UsersForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @Autowired
    UsersService iusersService;

    @Autowired
    public HttpSession session;

    @GetMapping("/login") //http://localhost:8080/login
    public String login(){
        var session = (UsersForm)this.session.getAttribute("sessionUser");
        if (session != null){
            return "redirect:/login-redirect";
        }
        return "login";
    }



}
