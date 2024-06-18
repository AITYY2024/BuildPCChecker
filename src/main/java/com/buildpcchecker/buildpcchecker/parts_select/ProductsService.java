package com.buildpcchecker.buildpcchecker.parts_select;


import com.buildpcchecker.buildpcchecker.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    private ProductsDao productsDao;


    //選んだカテゴリーのパーツを全て表示する
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
    //SSDのテーブルを全て表示する
    @Override
    public  List<SsdSelectForm> tableSsdParts(){
        return productsDao.tableSsdParts();
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

    //    //GPUのテーブルから検索したものを表示する
    @Override
    public List<GpuSelectForm> searchGpuParts(String gpu_name) {
            List<GpuSelectForm> gpuList = productsDao.searchGpuParts(gpu_name);
//        if(gpuList == null){
//                throw new PartsNotFoundException();
//        }
            return gpuList;
    }

    //    //Memoryのテーブルから検索したものを表示する
        @Override
    public List<MemorySelectForm> searchMemoryParts(String memory_name) {
            List<MemorySelectForm> memoryList = productsDao.searchMemoryParts(memory_name);
//        if(memoryList == null){
//                throw new PartsNotFoundException();
//        }
            return memoryList;
    }

       //Mbのテーブルから検索したものを表示する
        @Override
    public List<MbSelectForm> searchMbParts(String mb_name) {
            List<MbSelectForm> mbList = productsDao.searchMbParts(mb_name);
//        if(mbList == null){
//                throw new PartsNotFoundException();
//        }
            return mbList;
    }

       //SSDのテーブルから検索したものを表示する
        @Override
    public List<SsdSelectForm> searchSsdParts(String ssd_name) {
            List<SsdSelectForm> ssdList = productsDao.searchSsdParts(ssd_name);
//        if(ssdList == null){
//                throw new PartsNotFoundException();
//        }
            return ssdList;
    }

        //PSUのテーブルから検索したものを表示する
        @Override
    public List<PsuSelectForm> searchPsuParts(String psu_name) {
            List<PsuSelectForm> psuList = productsDao.searchPsuParts(psu_name);
//        if(psuList == null){
//                throw new PartsNotFoundException();
//        }
            return psuList;
    }

    //    //OSのテーブルから検索したものを表示する
        @Override
    public List<OsSelectForm> searchOsParts(String os_name) {
            List<OsSelectForm> osList = productsDao.searchOsParts(os_name);
//        if(osList == null){
//                throw new PartsNotFoundException();
//        }
            return osList;
    }

}
