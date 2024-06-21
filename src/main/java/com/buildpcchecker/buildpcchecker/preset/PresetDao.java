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

    //プリセットテーブル一覧
    @Override
    public List<PresetListForm> findAll(Integer user_id) {
        var param = new MapSqlParameterSource();
        param.addValue("user_id", user_id);
        return jdbcTemplate.query("SELECT * FROM preset WHERE user_id = :user_id;", param,
                new DataClassRowMapper<>(PresetListForm.class));
    }

    //プリセット詳細表示
    @Override
    public PresetListForm findById(Integer preset_id) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        var list = jdbcTemplate.query("SELECT * FROM preset WHERE preset_id = :preset_id;", param,
                new DataClassRowMapper<>(PresetListForm.class));
        return list.isEmpty() ? null : list.get(0);
    }

    //プリセットテーブル削除
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

    //プリセットコピー
    @Override
    public Integer copyPreset(PresetListFormJs presetListFormJs) {
        var param = new MapSqlParameterSource();
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
        return jdbcTemplate.update("INSERT INTO preset" +
                                        "(preset_name, " +
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


//    //プリセット更新
//    @Override
//    public Integer updatePreset(Integer preset_id) {
//        var param = new MapSqlParameterSource();
//        param.addValue("preset_id", preset_id);
//        return jdbcTemplate.update("UPDATE preset SET );
//    }

}
