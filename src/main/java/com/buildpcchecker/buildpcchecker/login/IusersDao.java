package com.buildpcchecker.buildpcchecker.login;

import com.buildpcchecker.buildpcchecker.date.UsersForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IusersDao implements UsersDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //ログイン
    @Override
    public UsersForm findByUser(String userName, String password){
        var param = new MapSqlParameterSource();
        param.addValue("user_name", userName);
        param.addValue("password", password);

        var list = jdbcTemplate.query("SELECT * FROM users " +
                                    "WHERE user_name = :user_name AND password = :password"
                                        ,param ,new DataClassRowMapper<>(UsersForm.class));
        return list.isEmpty() ? null : list.get(0);
    }

    //新規登録
    @Override
    public int insert(String userName, String password){
        var param = new MapSqlParameterSource();
        param.addValue("user_name", userName);
        param.addValue("password", password);
        return jdbcTemplate.update("INSERT INTO users (user_name,password,role) " +
                                    "VALUES (:user_name,:password,2)",param);
    }
}
