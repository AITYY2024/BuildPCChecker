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
    public List<CpuSelectForm> tableCpuParts(String chipset_name){

        var param = new MapSqlParameterSource();
        param.addValue("chipset_name", "%" + chipset_name + "%");
        var list = jdbcTemplate.query("""
                SELECT * FROM cpu
                WHERE
                gen IN (SELECT cpu_generation FROM compatible WHERE chipset_name LIKE :chipset_name ORDER BY id)
                ORDER BY id
                """, param, new DataClassRowMapper<>(CpuSelectForm.class));
        return list;
    }

    //GPUのテーブルを全て表示する
    @Override
    public List<GpuSelectForm> tableGpuParts(){
        return jdbcTemplate.query("""
                SELECT * FROM gpu ORDER BY id
                """,new DataClassRowMapper<>(GpuSelectForm.class));
    }
    //Memoryのテーブルを全て表示する
    @Override
    public List<MemorySelectForm> tableMemoryParts(){
        return jdbcTemplate.query("""
                SELECT * FROM memory ORDER BY id
                """,new DataClassRowMapper<>(MemorySelectForm.class));
    }

    //Mbのテーブルを全て表示する
    @Override
    public List<MbSelectForm> tableMbParts(String cpu_generation){
        var param = new MapSqlParameterSource();
        param.addValue("cpu_generation", "%" + cpu_generation + "%");
        var list = jdbcTemplate.query("""
            SELECT * FROM mb
            WHERE
            chipset IN (SELECT chipset_name FROM compatible WHERE cpu_generation LIKE :cpu_generation ORDER BY id)
            ORDER BY id
            """, param, new DataClassRowMapper<>(MbSelectForm.class));
        return list;
    }

    //SSDのテーブルを全て表示する
    @Override
    public List<SsdSelectForm> tableSsdParts(){
        return jdbcTemplate.query("""
                SELECT * FROM ssd ORDER BY id
                """,new DataClassRowMapper<>(SsdSelectForm.class));
    }

    //PSUのテーブルを全て表示する
    @Override
    public List<PsuSelectForm> tablePsuParts(){
        return jdbcTemplate.query("""
                SELECT * FROM psu ORDER BY id
                """,new DataClassRowMapper<>(PsuSelectForm.class));
    }

    //Osのテーブルを全て表示する
    @Override
    public List<OsSelectForm> tableOsParts(){
        return jdbcTemplate.query("""
                SELECT * FROM os ORDER BY id
                """,new DataClassRowMapper<>(OsSelectForm.class));
    }

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
    @Override
    public List<CpuSelectForm> searchCpuParts(
            String cpu_name,String chipset_name,int lowerLimit,int upperLimit){
        var param = new MapSqlParameterSource();
        param.addValue("cpu_name", "%" + cpu_name + "%");
        param.addValue("chipset_name", "%" + chipset_name + "%");
        param.addValue("lowerLimit",lowerLimit);
        param.addValue("upperLimit",upperLimit);
        var list = jdbcTemplate.query("""
                SELECT * FROM cpu
                WHERE
                gen IN (SELECT cpu_generation FROM compatible WHERE chipset_name LIKE :chipset_name)
                AND
                price >= :lowerLimit
                AND
                price <= :upperLimit
                AND
                product_name LIKE :cpu_name
                ORDER BY id""", param, new DataClassRowMapper<>(CpuSelectForm.class));
        return list;
    }

    //GPUのテーブルから検索したものを表示する
    @Override
    public List<GpuSelectForm> searchGpuParts(String gpu_name,int lowerLimit,int upperLimit){
        var param = new MapSqlParameterSource();
        param.addValue("gpu_name", "%" + gpu_name + "%");
        param.addValue("lowerLimit",lowerLimit);
        param.addValue("upperLimit",upperLimit);
        var list = jdbcTemplate.query("""
                SELECT * FROM gpu
                WHERE product_name LIKE :gpu_name
                AND
                price >= :lowerLimit
                AND
                price <= :upperLimit
                ORDER BY id""", param, new DataClassRowMapper<>(GpuSelectForm.class));
        return list;
    }

    //Memoryのテーブルから検索したものを表示する
    @Override
    public List<MemorySelectForm> searchMemoryParts(String memory_name,int lowerLimit,int upperLimit){
        var param = new MapSqlParameterSource();
        param.addValue("memory_name", "%" + memory_name + "%");
        param.addValue("lowerLimit",lowerLimit);
        param.addValue("upperLimit",upperLimit);
        var list = jdbcTemplate.query("""
                SELECT * FROM memory
                WHERE product_name LIKE :memory_name
                                AND
                price >= :lowerLimit
                AND
                price <= :upperLimit
                ORDER BY id
                """, param, new DataClassRowMapper<>(MemorySelectForm.class));
        return list;
    }

    //Mbのテーブルから検索したものを表示する
    @Override
    public List<MbSelectForm> searchMbParts(
            String mb_name,String cpu_generation,int lowerLimit,int upperLimit){
        var param = new MapSqlParameterSource();
        param.addValue("mb_name", "%" + mb_name + "%");
        param.addValue("cpu_generation", "%" + cpu_generation + "%");
        param.addValue("lowerLimit",lowerLimit);
        param.addValue("upperLimit",upperLimit);
        var list = jdbcTemplate.query("""
            SELECT * FROM mb
            WHERE
            chipset IN (SELECT chipset_name FROM compatible WHERE cpu_generation LIKE :cpu_generation)
            AND
            price >= :lowerLimit
            AND
            price <= :upperLimit
            AND
            product_name LIKE :mb_name
            ORDER BY id""", param, new DataClassRowMapper<>(MbSelectForm.class));
        return list;
    }

    //SSDのテーブルから検索したものを表示する
    @Override
    public List<SsdSelectForm> searchSsdParts(String ssd_name,int lowerLimit,int upperLimit){
        var param = new MapSqlParameterSource();
        param.addValue("ssd_name", "%" + ssd_name + "%");
        param.addValue("lowerLimit",lowerLimit);
        param.addValue("upperLimit",upperLimit);
        var list = jdbcTemplate.query("""
                SELECT * FROM ssd
                WHERE product_name LIKE :ssd_name
                AND
                price >= :lowerLimit
                AND
                price <= :upperLimit
                ORDER BY id""", param, new DataClassRowMapper<>(SsdSelectForm.class));
        return list;
    }

    //PSUのテーブルから検索したものを表示する
    @Override
    public List<PsuSelectForm> searchPsuParts(String psu_name,int lowerLimit,int upperLimit){
        var param = new MapSqlParameterSource();
        param.addValue("psu_name", "%" + psu_name + "%");
        param.addValue("lowerLimit",lowerLimit);
        param.addValue("upperLimit",upperLimit);
        var list = jdbcTemplate.query("""
                SELECT * FROM psu
                WHERE product_name LIKE :psu_name
                AND
                price >= :lowerLimit
                AND
                price <= :upperLimit
                ORDER BY id
                """, param, new DataClassRowMapper<>(PsuSelectForm.class));
        return list;
    }

    //OSのテーブルから検索したものを表示する
    @Override
    public List<OsSelectForm> searchOsParts(String os_name,int lowerLimit,int upperLimit){
        var param = new MapSqlParameterSource();
        param.addValue("os_name", "%" + os_name + "%");
        param.addValue("lowerLimit",lowerLimit);
        param.addValue("upperLimit",upperLimit);
        var list = jdbcTemplate.query("""
                SELECT * FROM os
                WHERE product_name LIKE :os_name
                AND
                price >= :lowerLimit
                AND
                price <= :upperLimit
                ORDER BY id""", param, new DataClassRowMapper<>(OsSelectForm.class));
        return list;
    }

    //パーツをプリセット登録する
//    @Override
//    public Integer catchPresetInsert(PresetListForm presetListForm){
//        var param = new MapSqlParameterSource();
//        //プリセット名,ユーザー名を取得
//        param.addValue("preset_name", presetListForm.getPreset_name());
//        param.addValue("user_id", presetListForm.getUser_id());
//
//        //CPUを取得
//        param.addValue("cpu_id", presetListForm.getCpu_id());
//        param.addValue("cpu_name", presetListForm.getCpu_name());
//        param.addValue("cpu_url", presetListForm.getCpu_url());
//
//        //GPUを取得
//        param.addValue("gpu_id", presetListForm.getGpu_id());
//        param.addValue("gpu_name", presetListForm.getGpu_name());
//        param.addValue("gpu_url", presetListForm.getGpu_url());
//
//        //MemoryつまりRAMを取得
//        param.addValue("ram_id", presetListForm.getRam_id());
//        param.addValue("ram_name", presetListForm.getRam_name());
//        param.addValue("ram_url", presetListForm.getRam_url());
//
//        //MBを取得
//        param.addValue("mb_id", presetListForm.getMb_id());
//        param.addValue("mb_name", presetListForm.getMb_name());
//        param.addValue("mb_url", presetListForm.getMb_url());
//
//        //SSDを取得
//        param.addValue("ssd_id", presetListForm.getSsd_id());
//        param.addValue("ssd_name", presetListForm.getSsd_name());
//        param.addValue("ssd_url", presetListForm.getSsd_url());
//
//        //PSUを取得
//        param.addValue("psu_id", presetListForm.getPsu_id());
//        param.addValue("psu_name", presetListForm.getPsu_name());
//        param.addValue("psu_url", presetListForm.getPsu_url());
//
//        //OSを取得
//        param.addValue("os_id", presetListForm.getOs_id());
//        param.addValue("os_name", presetListForm.getOs_name());
//        param.addValue("os_url", presetListForm.getOs_url());
//
//        //メモ・合計を取得
//        param.addValue("description", presetListForm.getDescription());
//        param.addValue("total_amount", presetListForm.getTotal_amount());
//
//        return jdbcTemplate.update("""
//               INSERT INTO preset (
//               preset_name,user_id,
//               cpu_id,cpu_name,cpu_url,
//               gpu_id,gpu_name,gpu_url,
//               ram_id,ram_name,ram_url,
//               mb_id,mb_name,mb_url,
//               ssd_id,ssd_name,ssd_url,
//               psu_id,psu_name,psu_url,
//               os_id,os_name,os_url,
//               description,total_amount)
//               VALUES (
//               :preset_name,:user_id,
//               :cpu_id,:cpu_name,:cpu_url,
//               :gpu_id,:gpu_name,:gpu_url,
//               :ram_id,:ram_name,:ram_url,
//               :mb_id,:mb_name,:mb_url,
//               :ssd_id,:ssd_name,:ssd_url,
//               :psu_id,:psu_name,:psu_url,
//               :os_id,:os_name,:os_url,
//               :description,:total_amount)""", param);
//    }

    //プリセットIDからそれぞれのパーツの情報を取得
    public List<CpuSelectForm> getPresetCpuInfo(int preset_id){
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("""
                    SELECT * FROM cpu 
                    WHERE product_id = (
                    SELECT cpu_id FROM preset WHERE preset_id = :preset_id)
                    """, param, new DataClassRowMapper<>(CpuSelectForm.class));
        return list;
    }

    public List<GpuSelectForm> getPresetGpuInfo(int preset_id){
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("""
                    SELECT * FROM gpu 
                    WHERE product_id = (
                    SELECT gpu_id FROM preset WHERE preset_id = :preset_id)
                    """, param, new DataClassRowMapper<>(GpuSelectForm.class));
        return list;
    }

    public List<MemorySelectForm> getPresetMemoryInfo(int preset_id){
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("""
                    SELECT * FROM memory
                    WHERE product_id = (
                    SELECT ram_id FROM preset WHERE preset_id = :preset_id)
                    """, param, new DataClassRowMapper<>(MemorySelectForm.class));
        return list;
    }

    public List<MbSelectForm> getPresetMbInfo(int preset_id){
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("""
                    SELECT * FROM mb 
                    WHERE product_id = (
                    SELECT mb_id FROM preset WHERE preset_id = :preset_id)
                    """, param, new DataClassRowMapper<>(MbSelectForm.class));
        return list;
    }

    public List<SsdSelectForm> getPresetSsdInfo(int preset_id){
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("""
                    SELECT * FROM ssd 
                    WHERE product_id = (
                    SELECT ssd_id FROM preset WHERE preset_id = :preset_id)
                    """, param, new DataClassRowMapper<>(SsdSelectForm.class));
        return list;
    }

    public List<PsuSelectForm> getPresetPsuInfo(int preset_id){
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("""
                    SELECT * FROM psu
                    WHERE product_id = (
                    SELECT psu_id FROM preset WHERE preset_id = :preset_id)
                    """, param, new DataClassRowMapper<>(PsuSelectForm.class));
        return list;
    }

    public List<OsSelectForm> getPresetOsInfo(int preset_id){
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("""
                    SELECT * FROM os 
                    WHERE product_id = (
                    SELECT os_id FROM preset WHERE preset_id = :preset_id)
                    """, param, new DataClassRowMapper<>(OsSelectForm.class));
        return list;
    }

    public List<PresetListFormJs> getPresetDescriptionInfo(int preset_id){
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("""
                    SELECT preset_name, description FROM preset
                    WHERE preset_id = :preset_id
                    """, param, new DataClassRowMapper<>(PresetListFormJs.class));
        return list;
    }
}