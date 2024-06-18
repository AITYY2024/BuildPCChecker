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

    //選んだカテゴリーのパーツを全て表示する
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

    //SSDのテーブルを全て表示する
    @Override
    public List<SsdSelectForm> tableSsdParts(){
        return jdbcTemplate.query("""
                SELECT * FROM ssd
                """,new DataClassRowMapper<>(SsdSelectForm.class));
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
                WHERE product_name LIKE :cpu_name""", param, new DataClassRowMapper<>(CpuSelectForm.class));
            return list;
    }

    //GPUのテーブルから検索したものを表示する
    @Override
    public List<GpuSelectForm> searchGpuParts(String gpu_name){
            var param = new MapSqlParameterSource();
            param.addValue("gpu_name", "%" + gpu_name + "%");
            var list = jdbcTemplate.query("""
                SELECT * FROM gpu
                WHERE product_name LIKE :gpu_name""", param, new DataClassRowMapper<>(GpuSelectForm.class));
            return list;
    }

    //Memoryのテーブルから検索したものを表示する
    @Override
    public List<MemorySelectForm> searchMemoryParts(String memory_name){
            var param = new MapSqlParameterSource();
            param.addValue("memory_name", "%" + memory_name + "%");
            var list = jdbcTemplate.query("""
                SELECT * FROM memory
                WHERE product_name LIKE :memory_name""", param, new DataClassRowMapper<>(MemorySelectForm.class));
            return list;
    }

    //Mbのテーブルから検索したものを表示する
    @Override
    public List<MbSelectForm> searchMbParts(String mb_name){
            var param = new MapSqlParameterSource();
            param.addValue("mb_name", "%" + mb_name + "%");
            var list = jdbcTemplate.query("""
                SELECT * FROM mb
                WHERE product_name LIKE :mb_name""", param, new DataClassRowMapper<>(MbSelectForm.class));
            return list;
    }

    //SSDのテーブルから検索したものを表示する
    @Override
    public List<SsdSelectForm> searchSsdParts(String ssd_name){
            var param = new MapSqlParameterSource();
            param.addValue("ssd_name", "%" + ssd_name + "%");
            var list = jdbcTemplate.query("""
                SELECT * FROM ssd
                WHERE product_name LIKE :ssd_name""", param, new DataClassRowMapper<>(SsdSelectForm.class));
            return list;
    }

    //PSUのテーブルから検索したものを表示する
    @Override
    public List<PsuSelectForm> searchPsuParts(String psu_name){
            var param = new MapSqlParameterSource();
            param.addValue("psu_name", "%" + psu_name + "%");
            var list = jdbcTemplate.query("""
                SELECT * FROM psu
                WHERE product_name LIKE :psu_name""", param, new DataClassRowMapper<>(PsuSelectForm.class));
            return list;
    }

    //OSのテーブルから検索したものを表示する
    @Override
    public List<OsSelectForm> searchOsParts(String os_name){
            var param = new MapSqlParameterSource();
            param.addValue("os_name", "%" + os_name + "%");
            var list = jdbcTemplate.query("""
                SELECT * FROM os
                WHERE product_name LIKE :os_name""", param, new DataClassRowMapper<>(OsSelectForm.class));
            return list;
    }

}
