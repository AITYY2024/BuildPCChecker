package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleDisplayForm;
import com.buildpcchecker.buildpcchecker.date.CompatibleForm;

import java.util.List;

public interface ICompatibleService {

    List<CompatibleDisplayForm> compatibleAll();//互換性テーブル一覧

    CompatibleDisplayForm findById(int id);//互換性テーブル詳細

    List<String> cpuGen(); //CPU GEN

    List<String> mbChipset(); //MB CHIPSET

    int insert(CompatibleForm compatibleForm);//互換性テーブル追加

    int update(CompatibleForm compatibleForm);//互換性テーブル更新

    int delete(int id); //互換性テーブル削除
}
