package com.buildpcchecker.buildpcchecker.parts_select;


import com.buildpcchecker.buildpcchecker.date.UsersForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PartsSelectController {

    @Autowired
    ProductsService productsService;

    @Autowired
    public HttpSession session;

    @GetMapping("/parts-select")
    public String testparts(){

        var session = (UsersForm)this.session.getAttribute("sessionUser");
        if (session == null){
            return "redirect:/login";
        }

        if (session.getRole() != 2){
            return "redirect:/login-redirect";
        }

        return "/parts-select";
    }
}
