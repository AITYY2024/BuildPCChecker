package com.buildpcchecker.buildpcchecker.parts_select;


import com.buildpcchecker.buildpcchecker.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDao implements IProductsDao{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //CPUのテーブルを全て表示する
    @Override
    public List<CpuSelectForm> tableCpuParts(){
        return jdbcTemplate.query("""
                SELECT * FROM cpu
                """,new DataClassRowMapper<>(CpuSelectForm.class));
    }

    //GPUのテーブルを全て表示する
    @Override
    public List<GpuSelectForm> tableGpuParts(){
        return jdbcTemplate.query("""
                SELECT * FROM gpu
                """,new DataClassRowMapper<>(GpuSelectForm.class));
    }
    //Memoryのテーブルを全て表示する
    @Override
    public List<MemorySelectForm> tableMemoryParts(){
        return jdbcTemplate.query("""
                SELECT * FROM memory
                """,new DataClassRowMapper<>(MemorySelectForm.class));
    }

    //Mbのテーブルを全て表示する
    @Override
    public List<MbSelectForm> tableMbParts(){
        return jdbcTemplate.query("""
                SELECT * FROM mb
                """,new DataClassRowMapper<>(MbSelectForm.class));
    }

    //Storageのテーブルを全て表示する
    @Override
    public List<StorageSelectForm> tableStorageParts(){
        return jdbcTemplate.query("""
                SELECT * FROM storage
                """,new DataClassRowMapper<>(StorageSelectForm.class));
    }

    //PSUのテーブルを全て表示する
    @Override
    public List<PsuSelectForm> tablePsuParts(){
        return jdbcTemplate.query("""
                SELECT * FROM psu
                """,new DataClassRowMapper<>(PsuSelectForm.class));
    }

    //Osのテーブルを全て表示する
    @Override
    public List<OsSelectForm> tableOsParts(){
        return jdbcTemplate.query("""
                SELECT * FROM os
                """,new DataClassRowMapper<>(OsSelectForm.class));
    }

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
    @Override
    public List<CpuSelectForm> searchCpuParts(String cpu_name){
            var param = new MapSqlParameterSource();
            param.addValue("cpu_name", "%" + cpu_name + "%");
            var list = jdbcTemplate.query("""
                SELECT * FROM cpu
                WHERE product_name = :cpu_name""", param, new DataClassRowMapper<>(CpuSelectForm.class));
            return list;
    }

}
