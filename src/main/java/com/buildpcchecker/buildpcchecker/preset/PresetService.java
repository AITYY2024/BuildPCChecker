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
    public List<PresetListForm> findAll(){
        return presetDao.findAll();
    }

    //プリセットテーブル削除
    @Override
    public Integer delete(Integer preset_id){
        return presetDao.delete(preset_id);
    }
}
