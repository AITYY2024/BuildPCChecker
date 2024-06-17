package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompatibleRestController {

    @Autowired
    private IcompatibleService icompatibleService;

    //互換性テーブル一覧
//    @GetMapping("/test")
//    public ResponseEntity<List<CompatibleForm>> compatibleList() {
//        try {
//            var compatibleList = icompatibleService.compatibleAll();
//            return new ResponseEntity<>(compatibleList, HttpStatus.OK);
//        } catch (NoSuchException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    //互換性テーブル詳細
//    @GetMapping("/test")
//    public ResponseEntity<CompatibleForm>compatibleDetail(int id){
//        try {
//            var compatibleDetail = icompatibleService.findById(id);
//            return new ResponseEntity<>(compatibleDetail,HttpStatus.OK);
//        }catch (NoSuchException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    //互換性テーブル追加
//    @GetMapping("/test")
//    public ResponseEntity<Integer>compatibleInsert(CompatibleForm compatibleForm){
//        try {
//            var compatibleInsert = icompatibleService.insert(compatibleForm);
//            return new ResponseEntity<>(compatibleInsert,HttpStatus.OK);
//        }catch (NoSuchException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    //互換性テーブル更新
//    @GetMapping("/test")
//    public ResponseEntity<Integer>compatibleUpdate(CompatibleForm compatibleForm){
//        try {
//            var compatibleUpdate = icompatibleService.update(compatibleForm);
//            return new ResponseEntity<>(compatibleUpdate,HttpStatus.OK);
//        }catch (NoSuchException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

}
