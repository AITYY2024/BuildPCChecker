package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleDisplayForm;
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
//    public List<CompatibleForm> compatibleAll(){
    public List<CompatibleDisplayForm> compatibleAll(){
        return icompatibleDao.compatibleAll();
    }

    //互換性テーブル詳細
    @Override
    public CompatibleDisplayForm findById(int id){
        return icompatibleDao.findById(id);
    }

    //CPU GEN
    @Override
    public List<String> cpuGen(){ return icompatibleDao.cpuGen();}

    //MB CHIPSET
    @Override
    public List<String> mbChipset(){ return icompatibleDao.mbChipset();}

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

    //互換性テーブル削除
    @Override
    public int delete(int id){ return icompatibleDao.delete(id);}
}
