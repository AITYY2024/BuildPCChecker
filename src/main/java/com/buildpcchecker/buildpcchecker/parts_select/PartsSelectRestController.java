package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartsSelectRestController {

    @Autowired
    ProductsService productsService;


    //選んだカテゴリーのパーツを全て表示する
    //CPUのテーブルを全て表示する
//    @GetMapping("/")
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

    //GPUのテーブルを全て表示する
        @GetMapping("/api/getGpuList")
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
        @GetMapping("/api/getRamList")
    public ResponseEntity<List<MemorySelectForm>> memoryTable(){
        try {
            List<MemorySelectForm> testMemory = productsService.tableMemoryParts();
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testMemory, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Mbのテーブルを全て表示する
//        @GetMapping("/")
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
        @GetMapping("/api/getBySsdList")
    public ResponseEntity<List<SsdSelectForm>> ssdTable(){
        try {
            List<SsdSelectForm> testSsd = productsService.tableSsdParts();
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testSsd, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //PSUのテーブルを全て表示する
        @GetMapping("/api/getByPsuList")
    public ResponseEntity<List<PsuSelectForm>> psuTable(){
        try {
            List<PsuSelectForm> testPsu = productsService.tablePsuParts();
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testPsu, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Osのテーブルを全て表示する
        @GetMapping("/api/getOsList")
    public ResponseEntity<List<OsSelectForm>> osTable(){
        try {
            List<OsSelectForm> testOs = productsService.tableOsParts();
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testOs, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
    @GetMapping("/api/searchByCpuList")
    public ResponseEntity<List<CpuSelectForm>> cpuSearch(
            @RequestParam String cpu_name,@RequestParam String chipset_name
            ,@RequestParam int lowerLimit,@RequestParam int upperLimit){
        try {
            List<CpuSelectForm> testCpuSearch = productsService.searchCpuParts(cpu_name,chipset_name,lowerLimit,upperLimit);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testCpuSearch, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


//    //GPUのテーブルから検索したものを表示する
    @GetMapping("/api/searchByGpuList")
    public ResponseEntity<List<GpuSelectForm>> gpuSearch(
            @RequestParam String gpu_name,@RequestParam int lowerLimit,@RequestParam int upperLimit){
        try {
            List<GpuSelectForm> testGpuSearch = productsService.searchGpuParts(gpu_name,lowerLimit,upperLimit);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testGpuSearch, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Memoryのテーブルから検索したものを表示する
    @GetMapping("/api/searchByRamList")
    public ResponseEntity<List<MemorySelectForm>> memorySearch(
            @RequestParam String memory_name,@RequestParam int lowerLimit,@RequestParam int upperLimit){
        try {
            List<MemorySelectForm> testMemorySearch = productsService.searchMemoryParts(memory_name,lowerLimit,upperLimit);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testMemorySearch, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Mbのテーブルから検索したものを表示する
    @GetMapping("/api/searchByMbList")
    public ResponseEntity<List<MbSelectForm>> mbSearch(
            @RequestParam String mb_name,@RequestParam String cpu_generation
            ,@RequestParam int lowerLimit,@RequestParam int upperLimit){
        try {
            List<MbSelectForm> testMbSearch = productsService.searchMbParts(mb_name,cpu_generation,lowerLimit,upperLimit);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testMbSearch, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //SSDのテーブルから検索したものを表示する
    @GetMapping("/api/searchBySsdList")
    public ResponseEntity<List<SsdSelectForm>> ssdSearch(String ssd_name,int lowerLimit,int upperLimit){
        try {
            List<SsdSelectForm> testSsdSearch = productsService.searchSsdParts(ssd_name,lowerLimit,upperLimit);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testSsdSearch, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //PSUのテーブルから検索したものを表示する
    @GetMapping("/api/searchByPsuList")
    public ResponseEntity<List<PsuSelectForm>> psuSearch(String psu_name,int lowerLimit,int upperLimit) {
        try {
            List<PsuSelectForm> testPsuSearch = productsService.searchPsuParts(psu_name, lowerLimit, upperLimit);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(testPsuSearch, HttpStatus.OK);
        } catch (PartsNotFoundException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

        //OSのテーブルから検索したものを表示する
//    @GetMapping("/api/searchByOsList")
//    public ResponseEntity<List<OsSelectForm>> osSearch(String os_name,int lowerLimit,int upperLimit){
//        try {
//            List<OsSelectForm> testOsSearch = productsService.searchOsParts(os_name,lowerLimit,upperLimit);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(testOsSearch, HttpStatus.OK);
//        } catch (PartsNotFoundException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

        //プリセットを登録するAPI
//    @PostMapping(value = "/api/PresetListFormRegistration")
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
}
