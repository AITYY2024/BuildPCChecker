package com.buildpcchecker.buildpcchecker.parts_select;


import com.buildpcchecker.buildpcchecker.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    private ProductsDao productsDao;

    //CPUのテーブルを全て表示する
    @Override
    public  List<CpuSelectForm> tableCpuParts(){
        return productsDao.tableCpuParts();
    }
    //GPUのテーブルを全て表示する
    @Override
    public  List<GpuSelectForm> tableGpuParts(){
        return productsDao.tableGpuParts();
    }
    //Memoryのテーブルを全て表示する
    @Override
    public  List<MemorySelectForm> tableMemoryParts(){
        return productsDao.tableMemoryParts();
    }
    //Mbのテーブルを全て表示する
        @Override
    public  List<MbSelectForm> tableMbParts(){
        return productsDao.tableMbParts();
    }
    //Storageのテーブルを全て表示する
        @Override
    public  List<StorageSelectForm> tableStorageParts(){
        return productsDao.tableStorageParts();
    }
    //PSUのテーブルを全て表示する
        @Override
    public  List<PsuSelectForm> tablePsuParts(){
        return productsDao.tablePsuParts();
    }
    //Osのテーブルを全て表示する
        @Override
    public  List<OsSelectForm> tableOsParts(){
        return productsDao.tableOsParts();
    }

    //検索欄に打った文字が名前に入っているパーツを表示する
    //CPUのテーブルから検索したものを表示する
        @Override
    public List<CpuSelectForm> searchCpuParts(String cpu_name) {
            List<CpuSelectForm> cpuList = productsDao.searchCpuParts(cpu_name);
//        if(cpuList == null){
//                throw new PartsNotFoundException();
//        }
            return cpuList;
    }

}
