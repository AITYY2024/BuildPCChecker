package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;

import java.util.List;

public interface IPresetService {
    List<PresetListForm> findAll();

    int delete(int preset_id);
}
