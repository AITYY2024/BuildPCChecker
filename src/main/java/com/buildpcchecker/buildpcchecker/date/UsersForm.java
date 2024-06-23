package com.buildpcchecker.buildpcchecker.date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsersForm {

    private int id;//usersテーブルid

    @NotBlank(message = "ユーザーIDが空欄です")
    private String user_name;//ユーザー名

    @NotBlank(message = "パスワードが空欄です")
    private String password;//パスワード

    private int role;//権限
}
