package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IcompatibleDao implements CompatibleDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //互換性テーブル一覧
    @Override
    public List<CompatibleForm>compatibleAll(){
        return jdbcTemplate.query("SELECT * FROM compatible ORDER BY cpu_generation",
                                    new DataClassRowMapper<>(CompatibleForm.class));
    }

    //互換性テーブル詳細
    @Override
    public CompatibleForm findById(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("SELECT * FROM compatible WHERE id = :id",
                                        param, new DataClassRowMapper<>(CompatibleForm.class));
        return list.isEmpty() ? null : list.get(0);
    }

    //互換性テーブル追加
    @Override
    public int insert(CompatibleForm compatibleForm){
        var param = new MapSqlParameterSource();
        param.addValue("cpu_generation",compatibleForm.getCpu_generation());
        param.addValue("chipset_name",compatibleForm.getChipset_name());
        return jdbcTemplate.update("INSERT INTO compatible (cpu_generation,chipset_name)" +
                                    " VALUES (:cpu_generation,:chipset_name)",param);
    }

    //互換性テーブル更新
    @Override
    public int update(CompatibleForm compatibleForm){
        var param = new MapSqlParameterSource();
        param.addValue("id",compatibleForm.getId());
        param.addValue("cpu_generation",compatibleForm.getCpu_generation());
        param.addValue("chipset_name",compatibleForm.getChipset_name());
        return jdbcTemplate.update("UPDATE compatible " +
                                    "SET cpu_generation = :cpu_generation" +
                                    ",chipset_name = :chipset_name " +
                                    "WHERE id = :id",param);
    }

}
