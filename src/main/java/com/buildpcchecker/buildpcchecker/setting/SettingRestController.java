package com.buildpcchecker.buildpcchecker.setting;

import com.buildpcchecker.buildpcchecker.date.UsersForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingRestController {

    @Autowired
    private SettingService isettingService;

    @Autowired
    public HttpSession session;

    //アカウント削除
    @DeleteMapping("/api/userDelete")
    public ResponseEntity<Integer>userDelete(){
        try {
            var user = (UsersForm)session.getAttribute("sessionUser");
            session.invalidate();
            var userDelete = isettingService.delete(user.getId());
            return new ResponseEntity<>(userDelete,HttpStatus.OK);
        }catch (NoSuchIdException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
