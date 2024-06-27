package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import com.buildpcchecker.buildpcchecker.form.PresetListFormJs;
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

    //プリセット一覧表示
    @Override
    public List<PresetListForm> findAll(Integer user_id) {
        var param = new MapSqlParameterSource();
        param.addValue("user_id", user_id);
        return jdbcTemplate.query("SELECT * FROM preset WHERE user_id = :user_id ORDER BY preset_id", param,
                new DataClassRowMapper<>(PresetListForm.class));
    }

    //プリセット詳細表示
    @Override
    public PresetListForm findById(Integer preset_id) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("SELECT * FROM preset WHERE preset_id = :preset_id ORDER BY preset_id", param,
                new DataClassRowMapper<>(PresetListForm.class));
        return list.isEmpty() ? null : list.get(0);
    }

    //プリセット削除
    @Override
    public Integer deletePreset(Integer preset_id) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        return jdbcTemplate.update("DELETE FROM preset WHERE preset_id = :preset_id", param);
    }

    //プリセット編集
    @Override
    public Integer editPreset(PresetListFormJs presetListFormJs) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", presetListFormJs.getPresetId());
        param.addValue("preset_name", presetListFormJs.getPresetName());

        param.addValue("cpu_id", presetListFormJs.getCpuId());
        param.addValue("cpu_name", presetListFormJs.getCpuName());
        param.addValue("cpu_url", presetListFormJs.getCpuUrl());

        param.addValue("gpu_id", presetListFormJs.getGpuId());
        param.addValue("gpu_name", presetListFormJs.getGpuName());
        param.addValue("gpu_url", presetListFormJs.getGpuUrl());

        param.addValue("ram_id", presetListFormJs.getMemoryId());
        param.addValue("ram_name", presetListFormJs.getMemoryName());
        param.addValue("ram_url", presetListFormJs.getMemoryUrl());

        param.addValue("mb_id", presetListFormJs.getMbId());
        param.addValue("mb_name", presetListFormJs.getMbName());
        param.addValue("mb_url", presetListFormJs.getMbUrl());

        param.addValue("ssd_id", presetListFormJs.getSsdId());
        param.addValue("ssd_name", presetListFormJs.getSsdName());
        param.addValue("ssd_url", presetListFormJs.getSsdUrl());

        param.addValue("psu_id", presetListFormJs.getPsuId());
        param.addValue("psu_name", presetListFormJs.getPsuName());
        param.addValue("psu_url", presetListFormJs.getPsuUrl());

        param.addValue("os_id", presetListFormJs.getOsId());
        param.addValue("os_name", presetListFormJs.getOsName());
        param.addValue("os_url", presetListFormJs.getOsUrl());

        param.addValue("description", presetListFormJs.getDescription());
        param.addValue("total_amount", presetListFormJs.getTotalPrice());
        return jdbcTemplate.update("UPDATE preset SET " +
                "preset_name = :preset_name, " +
                "cpu_id = :cpu_id, cpu_name = :cpu_name, cpu_url = :cpu_url, " +
                "gpu_id = :gpu_id, gpu_name = :gpu_name, gpu_url = :gpu_url, " +
                "ram_id = :ram_id, ram_name = :ram_name, ram_url = :ram_url, " +
                "mb_id = :mb_id, mb_name = :mb_name, mb_url =:mb_url, " +
                "ssd_id = :ssd_id, ssd_name = :ssd_name, ssd_url = :ssd_url, " +
                "psu_id = :psu_id, psu_name = :psu_name, psu_url = :psu_url, " +
                "os_id = :os_id, os_name = :os_name, os_url = :os_url, " +
                "description = :description, " +
                "total_amount = :total_amount, " +
                "update_at = LOCALTIMESTAMP " +
                "WHERE preset_id = :preset_id",
                param);
    }

    //プリセット新規追加
    @Override
    public Integer insertPreset(PresetListFormJs presetListFormJs) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_name", presetListFormJs.getPresetName());
        param.addValue("user_id", presetListFormJs.getUserId());

        param.addValue("cpu_id", presetListFormJs.getCpuId());
        param.addValue("cpu_name", presetListFormJs.getCpuName());
        param.addValue("cpu_url", presetListFormJs.getCpuUrl());

        param.addValue("gpu_id", presetListFormJs.getGpuId());
        param.addValue("gpu_name", presetListFormJs.getGpuName());
        param.addValue("gpu_url", presetListFormJs.getGpuUrl());

        param.addValue("ram_id", presetListFormJs.getMemoryId());
        param.addValue("ram_name", presetListFormJs.getMemoryName());
        param.addValue("ram_url", presetListFormJs.getMemoryUrl());

        param.addValue("mb_id", presetListFormJs.getMbId());
        param.addValue("mb_name", presetListFormJs.getMbName());
        param.addValue("mb_url", presetListFormJs.getMbUrl());

        param.addValue("ssd_id", presetListFormJs.getSsdId());
        param.addValue("ssd_name", presetListFormJs.getSsdName());
        param.addValue("ssd_url", presetListFormJs.getSsdUrl());

        param.addValue("psu_id", presetListFormJs.getPsuId());
        param.addValue("psu_name", presetListFormJs.getPsuName());
        param.addValue("psu_url", presetListFormJs.getPsuUrl());

        param.addValue("os_id", presetListFormJs.getOsId());
        param.addValue("os_name", presetListFormJs.getOsName());
        param.addValue("os_url", presetListFormJs.getOsUrl());

        param.addValue("description", presetListFormJs.getDescription());
        param.addValue("total_amount", presetListFormJs.getTotalPrice());
        return jdbcTemplate.update("INSERT INTO preset" +
                        "(preset_name, " +
                        "user_id, " +
                        "cpu_id, cpu_name, cpu_url, " +
                        "gpu_id, gpu_name, gpu_url, " +
                        "ram_id, ram_name, ram_url, " +
                        "mb_id, mb_name, mb_url, " +
                        "ssd_id, ssd_name, ssd_url, " +
                        "psu_id, psu_name, psu_url, " +
                        "os_id, os_name, os_url, " +
                        "description, " +
                        "total_amount, " +
                        "update_at)" +

                        "VALUES(" +
                        ":preset_name, " +
                        ":user_id, " +
                        ":cpu_id, :cpu_name, :cpu_url, " +
                        ":gpu_id, :gpu_name, :gpu_url, " +
                        ":ram_id, :ram_name, :ram_url, " +
                        ":mb_id, :mb_name, :mb_url, " +
                        ":ssd_id, :ssd_name, :ssd_url, " +
                        ":psu_id, :psu_name, :psu_url, " +
                        ":os_id, :os_name, :os_url, " +
                        ":description, " +
                        ":total_amount, " +
                        "LOCALTIMESTAMP) "
                , param);
    }

    //プリセットコピー
    @Override
    public Integer copyPreset(PresetListForm data) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_name", data.getPreset_name());
        param.addValue("user_id", data.getUser_id());

        param.addValue("cpu_id", data.getCpu_id());
        param.addValue("cpu_name", data.getCpu_name());
        param.addValue("cpu_url", data.getCpu_url());

        param.addValue("gpu_id", data.getGpu_id());
        param.addValue("gpu_name", data.getGpu_name());
        param.addValue("gpu_url", data.getGpu_url());

        param.addValue("ram_id", data.getRam_id());
        param.addValue("ram_name", data.getRam_name());
        param.addValue("ram_url", data.getRam_url());

        param.addValue("mb_id", data.getMb_id());
        param.addValue("mb_name", data.getMb_name());
        param.addValue("mb_url", data.getMb_url());

        param.addValue("ssd_id", data.getSsd_id());
        param.addValue("ssd_name", data.getSsd_name());
        param.addValue("ssd_url", data.getSsd_url());

        param.addValue("psu_id", data.getPsu_id());
        param.addValue("psu_name", data.getPsu_name());
        param.addValue("psu_url", data.getPsu_url());

        param.addValue("os_id", data.getOs_id());
        param.addValue("os_name", data.getOs_name());
        param.addValue("os_url", data.getOs_url());

        param.addValue("description", data.getDescription());
        param.addValue("total_amount", data.getTotal_amount());
        return jdbcTemplate.update("INSERT INTO preset(" +
                        "preset_name, " +
                        "user_id, " +
                        "cpu_id, cpu_name, cpu_url, " +
                        "gpu_id, gpu_name, gpu_url, " +
                        "ram_id, ram_name, ram_url, " +
                        "mb_id, mb_name, mb_url, " +
                        "ssd_id, ssd_name, ssd_url, " +
                        "psu_id, psu_name, psu_url, " +
                        "os_id, os_name, os_url, " +
                        "description, " +
                        "total_amount, " +
                        "update_at)" +

                        "VALUES(" +
                        ":preset_name, " +
                        ":user_id, " +
                        ":cpu_id, :cpu_name, :cpu_url, " +
                        ":gpu_id, :gpu_name, :gpu_url, " +
                        ":ram_id, :ram_name, :ram_url, " +
                        ":mb_id, :mb_name, :mb_url, " +
                        ":ssd_id, :ssd_name, :ssd_url, " +
                        ":psu_id, :psu_name, :psu_url, " +
                        ":os_id, :os_name, :os_url, " +
                        ":description, " +
                        ":total_amount, " +
                        "LOCALTIMESTAMP) "
                , param);
    }

    //プリセット更新
    @Override
    public Integer updatePreset(Integer preset_id) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        return jdbcTemplate.update("""
                UPDATE preset
                SET cpu_name = COALESCE((SELECT product_name FROM cpu WHERE product_id = (SELECT cpu_id FROM preset WHERE preset_id = :preset_id)), '情報がありません'),
                    gpu_name = COALESCE((SELECT product_name FROM gpu WHERE product_id = (SELECT gpu_id FROM preset WHERE preset_id = :preset_id)), '情報がありません'),
                    ram_name = COALESCE((SELECT product_name FROM memory WHERE product_id = (SELECT ram_id FROM preset WHERE preset_id = :preset_id)), '情報がありません'),
                    mb_name = COALESCE((SELECT product_name FROM mb WHERE product_id = (SELECT mb_id FROM preset WHERE preset_id = :preset_id)), '情報がありません'),
                    ssd_name = COALESCE((SELECT product_name FROM ssd WHERE product_id = (SELECT ssd_id FROM preset WHERE preset_id = :preset_id)), '情報がありません'),
                    psu_name = COALESCE((SELECT product_name FROM psu WHERE product_id = (SELECT psu_id FROM preset WHERE preset_id = :preset_id)), '情報がありません'),
                    os_name = COALESCE((SELECT product_name FROM os WHERE product_id = (SELECT os_id FROM preset WHERE preset_id = :preset_id)), '情報がありません'),
                    total_amount = COALESCE(
                                  (SELECT price FROM cpu WHERE product_id = (SELECT cpu_id FROM preset WHERE preset_id = :preset_id)) +
                                  (SELECT price FROM gpu WHERE product_id = (SELECT gpu_id FROM preset WHERE preset_id = :preset_id)) +
                                  (SELECT price FROM memory WHERE product_id = (SELECT ram_id FROM preset WHERE preset_id = :preset_id)) +
                                  (SELECT price FROM mb WHERE product_id = (SELECT mb_id FROM preset WHERE preset_id = :preset_id)) +
                                  (SELECT price FROM ssd WHERE product_id = (SELECT ssd_id FROM preset WHERE preset_id = :preset_id)) +
                                  (SELECT price FROM psu WHERE product_id = (SELECT psu_id FROM preset WHERE preset_id = :preset_id)) +
                                  (SELECT price FROM os WHERE product_id = (SELECT os_id FROM preset WHERE preset_id = :preset_id)), -1)
                WHERE preset_id = :preset_id;""", param);
    }

}
