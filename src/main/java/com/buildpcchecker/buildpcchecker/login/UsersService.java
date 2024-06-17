package com.buildpcchecker.buildpcchecker.login;

import com.buildpcchecker.buildpcchecker.date.UsersForm;

public interface UsersService {

    UsersForm findByUser(String user_name, String password);//ログイン

    int insert(String user_name, String password);//新規登録
}
