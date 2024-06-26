package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.*;

import java.util.List;

public interface IProductsDao {

    //選んだカテゴリーのパーツを全て表示する
    //CPUのテーブルを全て表示する
    List<CpuSelectForm> tableCpuParts(String chipset_name);
    //GPUのテーブルを全て表示する
    List<GpuSelectForm> tableGpuParts();
    //Memoryのテーブルを全て表示する
    List<MemorySelectForm> tableMemoryParts();
    //Mbのテーブルを全て表示する
    List<MbSelectForm> tableMbParts(String cpu_generation);
    //SSDのテーブルを全て表示する
    List<SsdSelectForm> tableSsdParts();
    //PSUのテーブルを全て表示する
    List<PsuSelectForm> tablePsuParts();
    //Osのテーブルを全て表示する
    List<OsSelectForm> tableOsParts();

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
    List<CpuSelectForm> searchCpuParts(String cpu_name,String chipset_name,int lowerLimit,int upperLimit);
    //GPUのテーブルから検索したものを表示する
    List<GpuSelectForm> searchGpuParts(String gpu_name,int lowerLimit,int upperLimit);
    //Memoryのテーブルから検索したものを表示する
    List<MemorySelectForm> searchMemoryParts(String memory_name,int lowerLimit,int upperLimit);
    //Mbのテーブルから検索したものを表示する
    List<MbSelectForm> searchMbParts(String mb_name,String cpu_generation,int lowerLimit,int upperLimit);
    //SSDのテーブルから検索したものを表示する
    List<SsdSelectForm> searchSsdParts(String ssd_name,int lowerLimit,int upperLimit);
    //PSUのテーブルから検索したものを表示する
    List<PsuSelectForm> searchPsuParts(String psu_name,int lowerLimit,int upperLimit);
    //OSのテーブルから検索したものを表示する
    List<OsSelectForm> searchOsParts(String os_name,int lowerLimit,int upperLimit);



    //パーツをプリセット登録する
  //  Integer catchPresetInsert(PresetListForm presetListForm);

    //プリセットIDからそれぞれのパーツの情報を取得
    List<CpuSelectForm> getPresetCpuInfo(int preset_id);
    List<GpuSelectForm> getPresetGpuInfo(int preset_id);
    List<MemorySelectForm> getPresetMemoryInfo(int preset_id);
    List<MbSelectForm> getPresetMbInfo(int preset_id);
    List<SsdSelectForm> getPresetSsdInfo(int preset_id);
    List<PsuSelectForm> getPresetPsuInfo(int preset_id);
    List<OsSelectForm> getPresetOsInfo(int preset_id);
    List<PresetListFormJs> getPresetDescriptionInfo(int preset_id);
}
