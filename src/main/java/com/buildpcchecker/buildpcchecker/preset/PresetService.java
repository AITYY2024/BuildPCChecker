package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import com.buildpcchecker.buildpcchecker.form.PresetListFormJs;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PresetService implements IPresetService {

    @Autowired
    private PresetDao presetDao;

    //プリセット一覧表示
    @Override
    public List<PresetListForm> findAll(Integer user_id){
        return presetDao.findAll(user_id);
    }

    //プリセット詳細表示
    @Override
    public PresetListForm findById(Integer preset_id) {
        return presetDao.findById(preset_id);
    }

    //プリセット削除
    @Override
    public Integer deletePreset(Integer preset_id){
        return presetDao.deletePreset(preset_id);
    }

    //プリセット編集
    @Override
    public Integer editPreset(PresetListFormJs presetListFormJs) {
        return presetDao.editPreset(presetListFormJs);
    }

    //プリセットコピー
    @Override
    public Integer copyPreset(Integer preset_id){
        var data = findById(preset_id);
        return presetDao.copyPreset(data);
    }

    //プリセット更新
    @Override
    public Integer updatePreset(Integer preset_id){ return presetDao.updatePreset(preset_id);}

}
