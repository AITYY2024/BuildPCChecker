package com.buildpcchecker.buildpcchecker.date;

import lombok.Data;

@Data
public class UsersForm {

    private int id;//usersテーブルid

    private String user_name;//ユーザー名

    private String password;//パスワード

    private int role;//権限
}
