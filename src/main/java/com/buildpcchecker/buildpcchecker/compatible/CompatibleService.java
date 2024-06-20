package com.buildpcchecker.buildpcchecker.compatible;

import com.buildpcchecker.buildpcchecker.date.CompatibleDisplayForm;
import com.buildpcchecker.buildpcchecker.date.CompatibleForm;

import java.util.List;

public interface CompatibleService {

    List<CompatibleDisplayForm> compatibleAll();//互換性テーブル一覧

    CompatibleDisplayForm findById(int id);//互換性テーブル詳細

    int insert(CompatibleForm compatibleForm);//互換性テーブル追加

    int update(CompatibleForm compatibleForm);//互換性テーブル更新
}
