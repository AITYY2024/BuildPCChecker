package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class PresetRestController {

    @Autowired
    PresetService presetService;

    //プリセット一覧表示用
    @GetMapping("/test")
    public ResponseEntity<List<PresetListForm>> PresetList() {
        try {
            List<PresetListForm> presetList = presetService.findAll();
            // データとステータスコード200番を返す
            return new ResponseEntity<>(presetList, HttpStatus.OK);
        } catch (RuntimeException e) {
            // ステータスコード400番を返す
            e.printStackTrace();//エラー内容をコンソール画面に表示するための処理
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

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
