package com.buildpcchecker.buildpcchecker.login;

import com.buildpcchecker.buildpcchecker.date.UsersForm;

import java.util.List;

public interface UsersDao {

    UsersForm findByUser(String user_name, String password);//ログイン

    int insert(String user_name, String password);//新規登録

}
