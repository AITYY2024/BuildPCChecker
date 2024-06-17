package com.buildpcchecker.buildpcchecker.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingRestController {

    @Autowired
    private IsettingService isettingService;

    //アカウント削除
//    @GetMapping("/test")
//    public ResponseEntity<Integer>userDelete(int id){
//        try {
//            var userDelete = isettingService.delete(id);
//            return new ResponseEntity<>(userDelete,HttpStatus.OK);
//        }catch (NoSuchIdException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
