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

    @Override
    public List<PresetListForm> findAll(){

        System.out.println("abcd");

        return presetDao.findAll();
    }

    @Override
    public int delete(int preset_id){
        return presetDao.delete(preset_id);
    }
}
