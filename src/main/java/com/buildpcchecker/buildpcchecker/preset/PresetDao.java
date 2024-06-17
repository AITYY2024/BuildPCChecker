package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PresetDao implements IPresetDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //プリセットテーブル一覧
    @Override
    public List<PresetListForm> findAll() {
        return jdbcTemplate.query("SELECT * FROM preset;",
                new DataClassRowMapper<>(PresetListForm.class));
    }

    //プリセットテーブル削除
    @Override
    public Integer delete(Integer preset_id) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        return jdbcTemplate.update("DELETE FROM preset WHERE preset_id = :preset_id", param);
    }

}
