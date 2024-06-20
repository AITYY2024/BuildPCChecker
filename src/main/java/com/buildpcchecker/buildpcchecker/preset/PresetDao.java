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
    public List<PresetListForm> findAll(Integer user_id) {
        return jdbcTemplate.query("SELECT * FROM preset WHERE user_id = :user_id;",
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
    public Integer delete(Integer preset_id) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_id", preset_id);
        return jdbcTemplate.update("DELETE FROM preset WHERE preset_id = :preset_id", param);
    }

    //プリセット編集
    @Override
    public Integer update(PresetListForm presetListForm) {
        var param = new MapSqlParameterSource();
        param.addValue("preset_name", presetListForm.getPreset_name());

        param.addValue("cpu_id", presetListForm.getCpu_id());
        param.addValue("cpu_name", presetListForm.getCpu_name());
        param.addValue("cpu_url", presetListForm.getCpu_url());

        param.addValue("gpu_id", presetListForm.getGpu_id());
        param.addValue("gpu_name", presetListForm.getGpu_name());
        param.addValue("gpu_url", presetListForm.getGpu_url());

        param.addValue("ram_id", presetListForm.getRam_id());
        param.addValue("ram_name", presetListForm.getRam_name());
        param.addValue("ram_url", presetListForm.getRam_url());

        param.addValue("mb_id", presetListForm.getMb_id());
        param.addValue("mb_name", presetListForm.getMb_name());
        param.addValue("mb_url", presetListForm.getMb_url());

        param.addValue("ssd_id", presetListForm.getSsd_id());
        param.addValue("ssd_name", presetListForm.getSsd_name());
        param.addValue("ssd_url", presetListForm.getSsd_url());

        param.addValue("psu_id", presetListForm.getPsu_id());
        param.addValue("psu_name", presetListForm.getPsu_name());
        param.addValue("psu_url", presetListForm.getPsu_url());

        param.addValue("os_id", presetListForm.getOs_id());
        param.addValue("os_name", presetListForm.getOs_name());
        param.addValue("os_url", presetListForm.getOs_url());

        param.addValue("description", presetListForm.getDescription());
        param.addValue("total_amount", presetListForm.getTotal_amount());
        return jdbcTemplate.update("UPDATE preset SET " +
                "preset_name = :getCpu_id(), " +
                "cpu_id = :getCpu_id(), cpu_name = :getCpu_name(), cpu_url = :getCpu_url(), " +
                "gpu_id = :getGpu_id(), gpu_name = :getGpu_name(), gpu_url = :getGpu_url(), " +
                "ram_id = :getRam_id(), ram_name = :getRam_name(), ram_url = :getRam_url(), " +
                "mb_id = :getMb_id(), mb_name = :getMb_name(), mb_url =:getMb_url(), " +
                "ssd_id = :getSsd_id(), ssd_name = :getSsd_name(), ssd_url = :getSsd_url(), " +
                "psu_id = :getPsu_id(), psu_name = :getPsu_name(), psu_url = :getPsu_url(), " +
                "os_id = :getOs_id(), os_name = :getOs_name(), os_url = :getOs_url(), " +
                "description = :getDescription(), " +
                "total_amount = :getTotal_amount() " +
                "WHERE preset_id = :getPreset_id",
                param);
    }


//    SQL："UPDATE preset SET cpu_id = CPU, gpu_id = GPU, ram_id = RAM, ssd_id = SSD, psu_id = PSU,  WHERE preset_id = :preset_id;"
//    SQL："var PresetId = 1;" +
//            "UPDATE FROM preset " +
//            "SET cpu_name = SELECT product_name FROM cpu WHERE product_id = (SELECT cpu_id FROM preset WHERE PresetId)" +
//            "gpu_name = SELECT product_name FROM gpu WHERE Product_id = (SELECT gpu_id FROM preset WHERE PresetId)" +
//            "WHERE preset_id;"

    //プリセットコピー


    //プリセット更新
}
