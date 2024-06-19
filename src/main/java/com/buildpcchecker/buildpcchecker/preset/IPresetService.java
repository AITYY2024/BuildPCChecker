package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;

import java.util.List;

public interface IPresetService {
    List<PresetListForm> findAll();//プリセットレコード一覧

    Integer delete(Integer preset_id);//プリセットレコード削除
}
