package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompatibleController {
    @Autowired
    IcompatibleService icompatibleService;

//    @GetMapping("/test")//http://localhost:8080/test
//    public String test(){
//        System.out.println(icompatibleService.compatibleAll());//互換性テーブル一覧テスト
//
//        System.out.println(icompatibleService.findById(1));//互換性テーブル詳細テスト
//
//        var list = new CompatibleForm();//引数にForm型にしている場合setが必要
//        list.setId(0);
//        list.setChipset_name("4567");
//        list.setCpu_generation("123");
//        System.out.println(icompatibleService.insert(list));//互換性テーブル追加テスト
//
//
//        list.setId(2);
//        list.setChipset_name("ab");
//        list.setCpu_generation("12");
//        System.out.println(icompatibleService.update(list));//互換性テーブル更新テスト
//
//        return "test";//test.htmlを作る
//    }

    @GetMapping("/compatible") //http://localhost:8080/compatible
    public String compatible(){
        return "compatible";}

}
