package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PresetController {

    @Autowired
    PresetService presetService;

    @Autowired
    public HttpSession session;

    @GetMapping("/preset-list")
    public String presetList(){
        if(this.session.getAttribute("sessionUser") == null){
            return "redirect:/login";
        }
        return "/preset-list";
    }

}