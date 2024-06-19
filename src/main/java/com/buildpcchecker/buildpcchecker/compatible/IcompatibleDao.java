package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleDisplayForm;
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
    public List<CompatibleDisplayForm>compatibleAll(){
        return jdbcTemplate.query("SELECT * FROM compatible ORDER BY cpu_generation",
                                    new DataClassRowMapper<>(CompatibleDisplayForm.class));
    }

    //互換性テーブル詳細
    @Override
    public CompatibleDisplayForm findById(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("SELECT * FROM compatible WHERE id = :id",
                                        param, new DataClassRowMapper<>(CompatibleDisplayForm.class));
        return list.isEmpty() ? null : list.get(0);
    }

    //互換性テーブル追加
    @Override
    public int insert(CompatibleForm compatibleForm){
        var param = new MapSqlParameterSource();
        param.addValue("cpu_generation",compatibleForm.getCpuGen());
        param.addValue("chipset_name",compatibleForm.getChipset());
        return jdbcTemplate.update("INSERT INTO compatible (cpu_generation,chipset_name)" +
                                    " VALUES (:cpu_generation,:chipset_name)",param);
    }

    //互換性テーブル更新
    @Override
    public int update(CompatibleForm compatibleForm){
        var param = new MapSqlParameterSource();
        param.addValue("id",compatibleForm.getCompatibleId());
        param.addValue("cpu_generation",compatibleForm.getCpuGen());
        param.addValue("chipset_name",compatibleForm.getChipset());
        return jdbcTemplate.update("UPDATE compatible " +
                                    "SET cpu_generation = :cpu_generation" +
                                    ",chipset_name = :chipset_name " +
                                    "WHERE id = :id",param);
    }

}
