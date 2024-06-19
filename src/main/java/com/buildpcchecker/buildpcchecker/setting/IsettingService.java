package com.buildpcchecker.buildpcchecker.setting;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IsettingService implements SettingService{
    @Autowired
    IsettingDao isettingDao;

    //アカウント削除
    @Override
    public int delete (int id){
        return isettingDao.delete(id);
    }
}
