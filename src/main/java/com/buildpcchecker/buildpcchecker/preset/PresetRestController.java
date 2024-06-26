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
    IPresetService IpresetService;

    @Autowired
    private HttpSession session;

    // プリセット一覧表示用API
    @GetMapping("/api/presetList")
    public ResponseEntity<List<PresetListForm>> PresetList() {
        try {
            session.getAttribute("sessionUser");
            var userInfoSession = (UsersForm)session.getAttribute("sessionUser");
            List<PresetListForm> presetList = IpresetService.findAll(userInfoSession.getId());

//            List<PresetListForm> presetList = IpresetService.findAll(2);

            // データとステータスコード200番を返す
            return new ResponseEntity<>(presetList, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //使われていない状況
    //プリセット詳細表示用API
    @GetMapping("/api/presetDetail")
    public ResponseEntity<PresetListForm> presetDetail(@RequestParam("presetid") Integer preset_id) {
        try {
            PresetListForm presetDetails = IpresetService.findById(preset_id);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(presetDetails, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //プリセット削除用API
    @DeleteMapping("/api/presetDelete")
    public ResponseEntity<Integer> deletePreset(@RequestBody Integer preset_id) {
        try {
            Integer delete = IpresetService.deletePreset(preset_id);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(delete, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //プリセット編集用API
    @PutMapping("/api/presetSave")
    public ResponseEntity<Integer> editPreset(@RequestBody PresetListFormJs presetListFormJs) {
        try {
             Integer edit = IpresetService.editPreset(presetListFormJs);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(edit, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //新規追加用API
    @PostMapping("/api/presetSave")
    public ResponseEntity<Integer> insertPreset(@RequestBody PresetListFormJs presetListFormJs){
        try {
            var userInfoSession = (UsersForm)session.getAttribute("sessionUser");
            presetListFormJs.setUserId(userInfoSession.getId());
            Integer insert = IpresetService.insertPreset(presetListFormJs);

            // データとステータスコード200番を返す
            return new ResponseEntity<>(insert, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //プリセットコピー用API
    @PostMapping("/api/presetCopy")
    public ResponseEntity<Integer> copyPreset(@RequestBody Integer preset_id){
        try {
            Integer copy = IpresetService.copyPreset(preset_id);
            // データとステータスコード200番を返す
            return new ResponseEntity<>(copy, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //プリセット更新用API
    @PutMapping("/api/presetUpdate")
    public ResponseEntity<Integer> updatePreset(@RequestBody PresetListFormJs presetListFormJs){
        try {
            Integer update = IpresetService.updatePreset(presetListFormJs.getPresetId());
            // データとステータスコード200番を返す
            return new ResponseEntity<>(update, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}