package com.buildpcchecker.buildpcchecker.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SettingDao implements ISettingDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //アカウント削除
    @Override
    public int delete(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        return jdbcTemplate.update("DELETE FROM users WHERE id = :id",param);
    }
}
