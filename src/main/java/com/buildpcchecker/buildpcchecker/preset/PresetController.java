package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PresetController {

    @Autowired
    PresetService presetService;


//    @GetMapping("/test")//http://localhost:8080/test
//    public String test(){
//
//        System.out.println(presetService.findAll(1));//プリセットテーブル一覧テスト
//        System.out.println(presetService.delete(2));//プリセットテーブル削除テスト
//        System.out.println(presetService.update());//プリセットテーブル編集テスト
//
//        return "test";
//    }

    @GetMapping("/test")//http://localhost:8080/test
    public String test(){

//        System.out.println(presetService.findAll());//プリセットテーブル一覧テスト
//        System.out.println(presetService.delete(1));//プリセットテーブル削除テスト

        return "test-preset-list";
    }

}