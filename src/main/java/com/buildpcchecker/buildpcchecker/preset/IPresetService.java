package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import com.buildpcchecker.buildpcchecker.form.PresetListFormJs;

import java.util.List;

public interface IPresetService {

    List<PresetListForm> findAll(Integer user_id);//プリセットテーブル一覧

    PresetListForm findById(Integer preset_id);//プリセット詳細表示

    Integer deletePreset(Integer preset_id);//プリセットテーブル削除

    Integer editPreset(PresetListFormJs presetListFormJs);//プリセット編集

    Integer copyPreset(PresetListFormJs presetListFormJs);//プリセットコピー
}
