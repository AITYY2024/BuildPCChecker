package com.buildpcchecker.buildpcchecker.setting;

import com.buildpcchecker.buildpcchecker.date.CompatibleForm;
import com.buildpcchecker.buildpcchecker.date.UsersForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SettingRestController {

    @Autowired
    private IsettingService isettingService;

    @Autowired
    public HttpSession session;

    //アカウント削除
    @DeleteMapping("/api/userDelete")
    public ResponseEntity<Integer>userDelete(){
        try {
            var user = (UsersForm)session.getAttribute("sessionUser");
            var userDelete = isettingService.delete(user.getId());
            return new ResponseEntity<>(userDelete,HttpStatus.OK);
        }catch (NoSuchIdException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
