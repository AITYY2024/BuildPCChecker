package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;

import java.util.List;

public interface IPresetDao {
    List<PresetListForm> findAll();//プリセットテーブル一覧

    Integer delete(Integer preset_id);//プリセットテーブル削除
}
