package com.buildpcchecker.buildpcchecker.login;

import com.buildpcchecker.buildpcchecker.date.UsersForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersRestController {
    @Autowired
    private IusersService iusersService;

    @Autowired
    public HttpSession session;

    //ログイン
    @PostMapping("/api/user")
    public ResponseEntity<Integer>login(@RequestBody UsersForm usersForm){

        try {
            var login = iusersService.findByUser(usersForm.getUser_name(),usersForm.getPassword());

            if (login != null) {
                var sessionUser = new  UsersForm();
                sessionUser.setId(login.getId());
                sessionUser.setUser_name(login.getUser_name());
                sessionUser.setPassword(login.getPassword());
                sessionUser.setRole(login.getRole());
                session.setAttribute("sessionUser", sessionUser);
                if (login.getRole() == 1){
                    var role = 1;
                    return new ResponseEntity<>(role, HttpStatus.OK);
                }else if (login.getRole() == 2) {
                    var role = 2;
                    return new ResponseEntity<>(role, HttpStatus.OK);
                }
            } else {
                var role = 0;
                return new ResponseEntity<>(role, HttpStatus.OK);
            }
        } catch (NoSuchUsersException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //新規登録
    @PutMapping("/api/user_insert")
    public ResponseEntity<Integer>userInsert(@RequestBody UsersForm usersForm){
        try {
            var userInsert = iusersService.insert(usersForm.getUser_name(),usersForm.getPassword());
            return new ResponseEntity<>(userInsert,HttpStatus.OK);
        }catch (NoSuchUsersException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
