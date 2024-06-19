package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class PresetRestController {

    @Autowired
    PresetService presetService;

    //プリセット一覧表示用
    @GetMapping("/api/product")
    public ResponseEntity<List<PresetListForm>> PresetList(Integer user_id) {
        try {
            List<PresetListForm> presetList = presetService.findAll(1);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(presetList, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    //プリセット詳細表示
//    @GetMapping("/api/productDetail")
//    public ResponseEntity<PresetListForm> presetDetail(Integer preset_id) {
//        try {
//            PresetListForm presetDetails = presetService.findById(2);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(presetDetails, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //プリセット削除用
//    @DeleteMapping(value = "/api/productDelete")
//    public ResponseEntity<Integer> delete(@RequestBody PresetListForm presetListForm) {
//        try {
//            Integer deletedPreset = presetService.delete(1);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(deletedPreset, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //プリセット編集用
//    @PutMapping(value = "/api/")
//    public ResponseEntity inputUser(@RequestBody ) {
//        session.setAttribute("sessionUser", users);
//        try {
////            Integer deletedPreset = presetService.delete(1);
////            // データとステータスコード200番を返す
////            return new ResponseEntity<>(deletedPreset, HttpStatus.OK);
////        } catch (RuntimeException e) {
////            // ステータスコード400番を返す
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////        }
//        return ResponseEntity.ok(HttpEntity.EMPTY);
//    }

//    //テスト用（DeleteMappingを使用するにはJavaScript側からの指定がないといけない）
//    @GetMapping("/test")
//    public ResponseEntity<Integer> delete(Integer preset_id) {
//        try {
//            Integer deletedPreset = presetService.delete(1);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(deletedPreset, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //最終的に記述する内容
//    //プリセット削除用
//    @DeleteMapping("/test/{preset_id}")
//    public ResponseEntity<Integer> delete(@PathVariable Integer preset_id) {
//        try {
//            Integer deletedPreset = presetService.delete(preset_id);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(deletedPreset, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

}
