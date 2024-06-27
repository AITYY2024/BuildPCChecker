package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.UsersForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompatibleController {
    @Autowired
    CompatibleService icompatibleService;

    @Autowired
    public HttpSession session;

    @GetMapping("/compatible") //http://localhost:8080/compatible
    public String compatible(){
        var session = (UsersForm)this.session.getAttribute("sessionUser");
        if (session == null){
            return "redirect:/login";
        }

        if (session.getRole() != 1){
            return "redirect:/login-redirect";
        }

        return "compatible";}

}
