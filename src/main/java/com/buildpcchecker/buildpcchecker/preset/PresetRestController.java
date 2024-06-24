package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.date.UsersForm;
import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import com.buildpcchecker.buildpcchecker.form.PresetListFormJs;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    private HttpSession session;

//    //プリセット一覧表示用（テスト用）
//    @GetMapping("/api/product")
//    public ResponseEntity<List<PresetListForm>> PresetList() {
//        try {
//            List<PresetListForm> presetList = presetService.findAll(1);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(presetList, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    // sessionの情報を保存できないため、全体で繋げる時に完成させる
//    // プリセット一覧表示用API
//    @GetMapping("/api/preset")
//    public ResponseEntity<List<PresetListForm>> PresetList() {
//        try {
//            // session.setAttribute("sessionUser", 1);
//            //var userInfoSession = (UsersForm)session.getAttribute("sessionUser");
////            List<PresetListForm> presetList = presetService.findAll(userInfoSession.getId());
//
//            List<PresetListForm> presetList = presetService.findAll(2);
//
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(presetList, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //プリセット詳細表示用API
//    @GetMapping("/api/presetDetail")
//    public ResponseEntity<PresetListForm> presetDetail(@RequestParam("presetid") Integer preset_id) {
//        try {
//            PresetListForm presetDetails = presetService.findById(preset_id);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(presetDetails, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //プリセット削除用API
//    @DeleteMapping("/api/productDelete")
//    public ResponseEntity<Integer> deletePreset(@RequestBody Integer preset_id) {
//        try {
//            Integer delete = presetService.deletePreset(preset_id);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(delete, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //プリセット編集用API
//    @PutMapping("/api/productEdit")
//    public ResponseEntity<Integer> editPreset(@RequestBody PresetListFormJs presetListFormJs) {
//        try {
//             Integer edit = presetService.editPreset(presetListFormJs);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(edit, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //プリセットコピー用API
//    @PostMapping("/api/productCopy")
//    public ResponseEntity<Integer> copyPreset(@RequestBody PresetListFormJs presetListFormJs){
//        try {
//            Integer copy = presetService.copyPreset(presetListFormJs);
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(copy, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    //プリセット更新用API
//    @PutMapping("/api/productUpdate")
//    public ResponseEntity<Integer> updatePreset(@RequestBody PresetListFormJs presetListFormJs){
//        try {
//            Integer update = presetService.updatePreset(presetListFormJs.getPresetId());
//            // データとステータスコード200番を返す
//            return new ResponseEntity<>(update, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // ステータスコード400番を返す
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

}