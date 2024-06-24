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
    public UsersForm findByUser(String userName, String password){
        return iusersDao.findByUser(userName,password);
    }

    //新規登録
    @Override
    public int insert(String userName, String password){
        return iusersDao.insert(userName,password);
    }
}
