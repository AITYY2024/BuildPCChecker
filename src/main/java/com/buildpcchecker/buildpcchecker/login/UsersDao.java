package com.buildpcchecker.buildpcchecker.login;

import com.buildpcchecker.buildpcchecker.date.UsersForm;

import java.util.List;

public interface UsersDao {

    UsersForm findByUser(String userName, String password);//ログイン

    int insert(String userName, String password);//新規登録

}
