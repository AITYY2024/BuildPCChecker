package com.buildpcchecker.buildpcchecker.parts_select;


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
//        if(this.session.getAttribute("sessionUser") == null){
//            return "redirect:/login";
//        }

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
