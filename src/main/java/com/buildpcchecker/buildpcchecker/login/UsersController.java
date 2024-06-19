package com.buildpcchecker.buildpcchecker.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @Autowired
    IusersService iusersService;

//    @GetMapping("/test")
//    public String test(){
//        System.out.println(iusersService.findByUser("user","user"));//ログインテスト
//
//       System.out.println(iusersService.insert("user2","user2"));//新規登録テスト
//        return "test";
//    }

//    @GetMapping("/test")
//    public String login(){
//        return "test-login";
//    }
//
}
