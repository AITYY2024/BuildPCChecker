package com.buildpcchecker.buildpcchecker.login;

import com.buildpcchecker.buildpcchecker.date.UsersForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IusersService implements UsersService {

    @Autowired
    IusersDao iusersDao;

    //ログイン
    @Override
    public UsersForm findByUser(String user_name, String password){
        return iusersDao.findByUser(user_name,password);
    }

    //新規登録
    @Override
    public int insert(String user_name, String password){
        return iusersDao.insert(user_name,password);
    }
}
