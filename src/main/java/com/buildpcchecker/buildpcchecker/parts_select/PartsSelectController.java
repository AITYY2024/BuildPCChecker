package com.buildpcchecker.buildpcchecker.parts_select;


import com.buildpcchecker.buildpcchecker.form.CpuSelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PartsSelectController {

    @Autowired
    ProductsService productsService;

//    @GetMapping("/testPartsCategory")
//    public String cpuSearchPartsTest(){
//        List<CpuSelectForm> partsTable = productsService.selectParts();
//        System.out.println(partsTable);
//        return "/testPartsCategory";
//    }

}
