package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.*;

import java.util.List;

public interface IProductsService {
    //CPUのテーブルを全て表示する
    public List<CpuSelectForm> tableCpuParts();
    //GPUのテーブルを全て表示する
    public List<GpuSelectForm> tableGpuParts();
    //Memoryのテーブルを全て表示する
    public List<MemorySelectForm> tableMemoryParts();
    //Mbのテーブルを全て表示する
    public List<MbSelectForm> tableMbParts();
    //Storageのテーブルを全て表示する
    public List<StorageSelectForm> tableStorageParts();
    //PSUのテーブルを全て表示する
    public List<PsuSelectForm> tablePsuParts();
    //Osのテーブルを全て表示する
    public List<OsSelectForm> tableOsParts();

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
    public List<CpuSelectForm> searchCpuParts(String cpu_name);
}
