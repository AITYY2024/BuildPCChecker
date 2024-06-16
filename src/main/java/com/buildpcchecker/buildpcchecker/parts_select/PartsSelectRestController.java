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

    //CPUのテーブルを全て表示する
//    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<CpuSelectForm>> cpuTable(){
//        try {
//            List<CpuSelectForm> testCpu = productsService.tableCpuParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testCpu, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //GPUのテーブルを全て表示する
    @GetMapping("/testPartsCategory")
    public ResponseEntity<List<GpuSelectForm>> gpuTable(){
        try {
            List<GpuSelectForm> testGpu = productsService.tableGpuParts();
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testGpu, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    //Memoryのテーブルを全て表示する
    //    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<MemorySelectForm>> memoryTable(){
//        try {
//            List<MemorySelectForm> testMemory = productsService.tableMemoryParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testMemory, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //Mbのテーブルを全て表示する
    //    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<MbSelectForm>> mbTable(){
//        try {
//            List<MbSelectForm> testMb = productsService.tableMbParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testMb, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //Storageのテーブルを全て表示する
    //    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<StorageSelectForm>> StorageTable(){
//        try {
//            List<StorageSelectForm> testStorage = productsService.tableStorageParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testStorage, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //PSUのテーブルを全て表示する
    //    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<PsuSelectForm>> psuTable(){
//        try {
//            List<PsuSelectForm> testPsu = productsService.tablePsuParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testPsu, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //Osのテーブルを全て表示する
    //    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<OsSelectForm>> osTable(){
//        try {
//            List<OsSelectForm> testOs = productsService.tableOsParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testOs, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
    //    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<CpuSelectForm>> cpuSearch(){
//        try {
//            List<CpuSelectForm> testCpuSearch = productsService.searchCpuParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testOs, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }


}
