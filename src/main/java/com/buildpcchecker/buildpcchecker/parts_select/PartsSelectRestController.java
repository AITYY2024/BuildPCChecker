package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.CpuSelectForm;
import com.buildpcchecker.buildpcchecker.form.GpuSelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartsSelectRestController {

    @Autowired
    ProductsService productsService;

//    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<CpuSelectForm>> cpuSearch(){
//        try {
//            List<CpuSelectForm> testCpu = productsService.selectCpuParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testCpu, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
    @GetMapping("/testPartsCategory")
    public ResponseEntity<List<GpuSelectForm>> gpuSearch(){
        try {
            List<GpuSelectForm> testGpu = productsService.selectGpuParts();
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testGpu, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
