package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;

import java.util.List;

public interface IPresetDao {

    List<PresetListForm> findAll(Integer user_id);//プリセットテーブル一覧

    PresetListForm findById(Integer preset_id);//プリセット詳細表示

    Integer delete(Integer preset_id);//プリセットテーブル削除

    Integer update(PresetListForm presetListForm);//プリセット編集
}
