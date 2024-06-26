package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleDisplayForm;
import com.buildpcchecker.buildpcchecker.date.CompatibleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompatibleRestController {

    @Autowired
    private CompatibleService icompatibleService;

    //互換性テーブル一覧
    @GetMapping("/api/compatible")
    public ResponseEntity<List<CompatibleDisplayForm>> compatibleList() {
        try {
            var compatibleList = icompatibleService.compatibleAll();
            return new ResponseEntity<>(compatibleList, HttpStatus.OK);
        } catch (NoSuchException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //互換性テーブル詳細
//    @GetMapping("/api/compatible")
//    public ResponseEntity<CompatibleDisplayForm>compatibleDetail(@RequestBody CompatibleDisplayForm compatibleDisplayForm){
//        try {
//            var compatibleDetail = icompatibleService.findById(compatibleDisplayForm.getId());
//            return new ResponseEntity<>(compatibleDetail,HttpStatus.OK);
//        }catch (NoSuchException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //CPU GEN
//    @GetMapping("/api/compatible")
//    public  ResponseEntity<List<String>> cpuGen(){
//        try {
//            var cpuGen = icompatibleService.cpuGen();
//            return new ResponseEntity<>(cpuGen,HttpStatus.OK);
//        }catch (NoSuchException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //MB CHIPSET
    @GetMapping("/api/chipset")
    public ResponseEntity<List<String>> mbChipset(){
        try {
            var mbChipset = icompatibleService.mbChipset();
            return new ResponseEntity<>(mbChipset,HttpStatus.OK);
        }catch (NoSuchException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //互換性テーブル追加
    @PostMapping("/api/compatible")
    public ResponseEntity<Integer>compatibleInsert(@RequestBody CompatibleForm compatibleForm){
        try {
            var compatibleInsert = icompatibleService.insert(compatibleForm);
            return new ResponseEntity<>(compatibleInsert,HttpStatus.OK);
        }catch (NoSuchException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //互換性テーブル更新
//    @PutMapping("/api/compatible")
//    public ResponseEntity<Integer>compatibleUpdate(@RequestBody CompatibleForm compatibleForm){
//        try {
//            var compatibleUpdate = icompatibleService.update(compatibleForm);
//            return new ResponseEntity<>(compatibleUpdate,HttpStatus.OK);
//        }catch (NoSuchException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //互換性テーブル削除
    @DeleteMapping("/api/compatible")
    public ResponseEntity<Integer>compatibleDelete(@RequestBody int id){
        try {
            var compatibleDelete = icompatibleService.delete(id);
            return new ResponseEntity<>(compatibleDelete,HttpStatus.OK);
        }catch (NoSuchException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
