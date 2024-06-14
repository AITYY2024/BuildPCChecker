package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;

import java.util.List;

public interface IPresetDao {
    List<PresetListForm> findAll();

    int delete(int preset_id);
}
