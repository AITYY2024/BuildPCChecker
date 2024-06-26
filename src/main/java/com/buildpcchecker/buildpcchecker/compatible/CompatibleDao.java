package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleDisplayForm;
import com.buildpcchecker.buildpcchecker.date.CompatibleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompatibleDao implements ICompatibleDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate2;


    //互換性テーブル一覧
    @Override
    public List<CompatibleDisplayForm>compatibleAll(){
        return jdbcTemplate.query("""
                        SELECT *\s
                        FROM compatible
                        ORDER BY
                          CASE
                            WHEN cpu_generation LIKE 'Ryzen%' THEN CAST(SUBSTRING(cpu_generation FROM '(\\d+)') AS INTEGER)
                            WHEN cpu_generation LIKE '第%' THEN CAST(SUBSTRING(cpu_generation FROM '(\\d+)') AS INTEGER)
                          END DESC;""",
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

    //CPU GEN
    @Override
    public List<String> cpuGen(){
        return jdbcTemplate2.queryForList("""
                SELECT gen
                FROM cpu
                WHERE gen IS NOT NULL
                GROUP BY gen
                ORDER BY
                  CASE
                    WHEN gen LIKE 'Ryzen%' THEN CAST(SUBSTRING(gen FROM '(\\d+)') AS INTEGER)
                    WHEN gen LIKE '第%' THEN CAST(SUBSTRING(gen FROM '(\\d+)') AS INTEGER)
                  END DESC""", String.class);
    }

    //MB CHIPSET
    @Override
    public List<String>mbChipset(){
        return jdbcTemplate2.queryForList("""
                SELECT chipset
                FROM mb
                WHERE chipset IS NOT NULL
                GROUP BY chipset
                ORDER BY chipset DESC;""",String.class);
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

    //互換性テーブル削除
    @Override
    public int delete(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        return jdbcTemplate.update("DELETE FROM compatible WHERE id = :id",param);
    }

}
