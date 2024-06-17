package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.*;

import java.util.List;

public interface IProductsDao {
    //CPUのテーブルを全て表示する
    List<CpuSelectForm> tableCpuParts();
    //GPUのテーブルを全て表示する
    List<GpuSelectForm> tableGpuParts();
    //Memoryのテーブルを全て表示する
    List<MemorySelectForm> tableMemoryParts();
    //Mbのテーブルを全て表示する
    List<MbSelectForm> tableMbParts();
    //Storageのテーブルを全て表示する
    List<StorageSelectForm> tableStorageParts();
    //PSUのテーブルを全て表示する
    List<PsuSelectForm> tablePsuParts();
    //Osのテーブルを全て表示する
    List<OsSelectForm> tableOsParts();

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
    List<CpuSelectForm> searchCpuParts(String cpu_name);
}
