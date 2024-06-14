package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IcompatibleService implements CompatibleService{

    @Autowired
    private IcompatibleDao icompatibleDao;

    //互換性テーブル一覧
    @Override
    public List<CompatibleForm> compatibleList(){
        return icompatibleDao.compatibleAll();
    }

    //互換性テーブル詳細
    @Override
    public CompatibleForm findById(int id){
        return icompatibleDao.findById(id);
    }

    //互換性テーブル追加
    @Override
    public int insert(CompatibleForm compatibleForm){
        return icompatibleDao.insert(compatibleForm);
    }

    //互換性テーブル更新
    @Override
    public int update(CompatibleForm compatibleForm){
        return icompatibleDao.update(compatibleForm);
    }
}
