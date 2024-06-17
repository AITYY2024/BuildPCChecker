package com.buildpcchecker.buildpcchecker.login;

import com.buildpcchecker.buildpcchecker.date.UsersForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {
    @Autowired
    private IusersService iusersService;

    @Autowired
    public HttpSession session;

    //ログイン
    @PostMapping("/test")
    public ResponseEntity<UsersForm>login(String user_name, String password){
        try {
            var login = iusersService.findByUser(user_name,password);

            var sessionUser = new  UsersForm();
            sessionUser.setId(login.getId());
            sessionUser.setUser_name(login.getUser_name());
            sessionUser.setPassword(login.getPassword());
            sessionUser.setRole(login.getRole());
            session.setAttribute("sessionUser", sessionUser);

            return new ResponseEntity<>(login, HttpStatus.OK);
        }catch (NoSuchUsersException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //新規登録
//    @GetMapping("/test")
//    public ResponseEntity<Integer>userInsert(String user_name, String password){
//        try {
//            var userInsert = iusersService.insert(user_name,password);
//            return new ResponseEntity<>(userInsert,HttpStatus.OK);
//        }catch (NoSuchUsersException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
