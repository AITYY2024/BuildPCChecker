package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.*;

import java.util.List;

public interface IProductsDao {

    //選んだカテゴリーのパーツを全て表示する
    //CPUのテーブルを全て表示する
    List<CpuSelectForm> tableCpuParts();
    //GPUのテーブルを全て表示する
    List<GpuSelectForm> tableGpuParts();
    //Memoryのテーブルを全て表示する
    List<MemorySelectForm> tableMemoryParts();
    //Mbのテーブルを全て表示する
    List<MbSelectForm> tableMbParts();
    //SSDのテーブルを全て表示する
    List<SsdSelectForm> tableSsdParts();
    //PSUのテーブルを全て表示する
    List<PsuSelectForm> tablePsuParts();
    //Osのテーブルを全て表示する
    List<OsSelectForm> tableOsParts();

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
    List<CpuSelectForm> searchCpuParts(String cpu_name);
    //GPUのテーブルから検索したものを表示する
    List<GpuSelectForm> searchGpuParts(String gpu_name);
    //Memoryのテーブルから検索したものを表示する
    List<MemorySelectForm> searchMemoryParts(String memory_name);
    //Mbのテーブルから検索したものを表示する
    List<MbSelectForm> searchMbParts(String mb_name);
    //SSDのテーブルから検索したものを表示する
    List<SsdSelectForm> searchSsdParts(String ssd_name);
    //PSUのテーブルから検索したものを表示する
    List<PsuSelectForm> searchPsuParts(String psu_name);
    //OSのテーブルから検索したものを表示する
    List<OsSelectForm> searchOsParts(String os_name);



    //パーツをプリセット登録する
    Integer catchPresetInsert(PresetListForm presetListForm);

}
