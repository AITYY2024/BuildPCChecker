package com.buildpcchecker.buildpcchecker.preset;

import com.buildpcchecker.buildpcchecker.form.PresetListForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PresetService implements IPresetService {

    @Autowired
    private PresetDao presetDao;

    //プリセットテーブル一覧
    @Override
    public List<PresetListForm> findAll(Integer user_id){
        return presetDao.findAll(user_id);
    }

    //プリセット詳細表示
    @Override
    public PresetListForm findById(Integer preset_id) {
        return presetDao.findById(preset_id);
    }

    //プリセットテーブル削除
    @Override
    public Integer delete(Integer preset_id){
        return presetDao.delete(preset_id);
    }

    //プリセット編集
    @Override
    public Integer update(PresetListForm presetListForm) {
        return presetDao.update(presetListForm);
    }
}
