package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartsSelectRestController {

    @Autowired
    ProductsService productsService;


    //選んだカテゴリーのパーツを全て表示する
    //CPUのテーブルを全て表示する
//    @GetMapping("/tryDateSend")
//    public ResponseEntity<List<CpuSelectForm>> cpuTable(String chipset_name){
//        try {
//            List<CpuSelectForm> testCpu = productsService.tableCpuParts(chipset_name);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testCpu, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //GPUのテーブルを全て表示する
//        @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<GpuSelectForm>> gpuTable(){
//        try {
//            List<GpuSelectForm> testGpu = productsService.tableGpuParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testGpu, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //Memoryのテーブルを全て表示する
//        @GetMapping("/testPartsCategory")
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
//        @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<MbSelectForm>> mbTable(String cpu_generation){
//        try {
//            List<MbSelectForm> testMb = productsService.tableMbParts(cpu_generation);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testMb, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //SSDのテーブルを全て表示する
//        @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<SsdSelectForm>> ssdTable(){
//        try {
//            List<SsdSelectForm> testSsd = productsService.tableSsdParts();
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testSsd, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //PSUのテーブルを全て表示する
//        @GetMapping("/testPartsCategory")
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
//        @GetMapping("/testPartsCategory")
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
//            List<CpuSelectForm> testCpuSearch = productsService.searchCpuParts("AMD","AMD X670E",0,500000);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testCpuSearch, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }


//    //GPUのテーブルから検索したものを表示する
//    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<GpuSelectForm>> gpuSearch(){
//        try {
//            List<GpuSelectForm> testGpuSearch = productsService.searchGpuParts("4080",0,1000000);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testGpuSearch, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //Memoryのテーブルから検索したものを表示する
//    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<MemorySelectForm>> memorySearch(){
//        try {
//            List<MemorySelectForm> testMemorySearch = productsService.searchMemoryParts("16",0,1000000);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testMemorySearch, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //Mbのテーブルから検索したものを表示する
//    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<MbSelectForm>> mbSearch(){
//        try {
//            List<MbSelectForm> testMbSearch = productsService.searchMbParts("ASRock","Ryzen 7000シリーズ",0,100000);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testMbSearch, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //SSDのテーブルから検索したものを表示する
//    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<SsdSelectForm>> ssdSearch(){
//        try {
//            List<SsdSelectForm> testSsdSearch = productsService.searchSsdParts("512",0,1000000);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testSsdSearch, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //PSUのテーブルから検索したものを表示する
//    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<PsuSelectForm>> psuSearch(){
//        try {
//            List<PsuSelectForm> testPsuSearch = productsService.searchPsuParts("100",0,1000000);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testPsuSearch, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //OSのテーブルから検索したものを表示する
//    @GetMapping("/testPartsCategory")
//    public ResponseEntity<List<OsSelectForm>> osSearch(){
//        try {
//            List<OsSelectForm> testOsSearch = productsService.searchOsParts("Windows",0,1000000);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testOsSearch, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //プリセットを登録するAPI
//    @PostMapping(value = "/catchPresetRegistration")
//    public ResponseEntity<Integer> presetRegistration(@RequestBody PresetListForm presetListForm){
//        try {
//            Integer presetregistration = productsService.catchPresetInsert(presetListForm);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(presetregistration, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

}
