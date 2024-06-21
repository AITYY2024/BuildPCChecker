package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import com.buildpcchecker.buildpcchecker.form.PresetListFormJs;

import java.util.List;

public interface IPresetDao {

    List<PresetListForm> findAll(Integer user_id);//プリセット一覧表示

    PresetListForm findById(Integer preset_id);//プリセット詳細表示

    Integer deletePreset(Integer preset_id);//プリセット削除

    Integer editPreset(PresetListFormJs presetListFormJs);//プリセット編集

    Integer copyPreset(PresetListFormJs presetListFormJs);//プリセットコピー

    Integer updatePreset(Integer preset_id);//プリセット更新
}
