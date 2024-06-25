package com.buildpcchecker.buildpcchecker.parts_select;


import com.buildpcchecker.buildpcchecker.form.CpuSelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PartsSelectController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/parts-select")
    public String testparts(){
        return "/parts-select";
    }
//    @PostMapping("/testPartsCategory")
//    public String testcheck(){
//        return "/testPartsCategory";
//    }
//
//    @GetMapping("/test-parts-select")
//    public String testpartsSelect(){
//        return "/test-parts-select";
//    }
//    @PostMapping("/test-parts-select")
//    public String testpartSelect(){
//        return "/testPartsCategory";
//    }



}
