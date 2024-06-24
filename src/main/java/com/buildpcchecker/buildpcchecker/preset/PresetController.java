package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PresetController {

    @Autowired
    PresetService presetService;

    @GetMapping("/preset-list")
    public String presetList(){
        return "preset-list";
    }

}