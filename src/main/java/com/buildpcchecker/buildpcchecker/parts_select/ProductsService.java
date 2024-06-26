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
    public  List<CpuSelectForm> tableCpuParts(String chipset_name){
        return productsDao.tableCpuParts(chipset_name);
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
    public  List<MbSelectForm> tableMbParts(String cpu_generation){
        return productsDao.tableMbParts(cpu_generation);
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
    public List<CpuSelectForm> searchCpuParts(String cpu_name,String chipset_name,int lowerLimit,int upperLimit) {
            List<CpuSelectForm> cpuList = productsDao.searchCpuParts(cpu_name,chipset_name,lowerLimit,upperLimit);
            return cpuList;
    }

    //    //GPUのテーブルから検索したものを表示する
    @Override
    public List<GpuSelectForm> searchGpuParts(String gpu_name,int lowerLimit,int upperLimit) {
            List<GpuSelectForm> gpuList = productsDao.searchGpuParts(gpu_name,lowerLimit,upperLimit);
            return gpuList;
    }

    //    //Memoryのテーブルから検索したものを表示する
    @Override
    public List<MemorySelectForm> searchMemoryParts(String memory_name,  String ramSpec, int lowerLimit,int upperLimit) {
            List<MemorySelectForm> memoryList = productsDao.searchMemoryParts(memory_name, ramSpec, lowerLimit, upperLimit);
            return memoryList;
    }

    //Mbのテーブルから検索したものを表示する
    @Override
    public List<MbSelectForm> searchMbParts(String mb_name,String cpu_generation, String ramSpec, int lowerLimit,int upperLimit) {
            List<MbSelectForm> mbList = productsDao.searchMbParts(mb_name,cpu_generation, ramSpec, lowerLimit, upperLimit);
            return mbList;
    }

       //SSDのテーブルから検索したものを表示する
        @Override
    public List<SsdSelectForm> searchSsdParts(String ssd_name,int lowerLimit,int upperLimit) {
            List<SsdSelectForm> ssdList = productsDao.searchSsdParts(ssd_name,lowerLimit,upperLimit);
            return ssdList;
    }

        //PSUのテーブルから検索したものを表示する
        @Override
    public List<PsuSelectForm> searchPsuParts(String psu_name,int lowerLimit,int upperLimit) {
            List<PsuSelectForm> psuList = productsDao.searchPsuParts(psu_name,lowerLimit,upperLimit);
            return psuList;
    }

    //    //OSのテーブルから検索したものを表示する
        @Override
    public List<OsSelectForm> searchOsParts(String os_name,int lowerLimit,int upperLimit) {
            List<OsSelectForm> osList = productsDao.searchOsParts(os_name,lowerLimit,upperLimit);
            return osList;
    }

    //パーツをプリセット登録する
//    public Integer catchPresetInsert(PresetListForm presetListForm){
//        Integer insertNumber = productsDao.catchPresetInsert(presetListForm);
//        return insertNumber;
//    }

    //プリセットIDからそれぞれのパーツの情報を取得
    public List<CpuSelectForm> getPresetCpuInfo(int preset_id){
        List<CpuSelectForm> cpuList = productsDao.getPresetCpuInfo(preset_id);
        return cpuList;
    }

    public List<GpuSelectForm> getPresetGpuInfo(int preset_id){
        List<GpuSelectForm> gpuList = productsDao.getPresetGpuInfo(preset_id);
        return gpuList;
    }
    public List<MemorySelectForm> getPresetMemoryInfo(int preset_id){
        List<MemorySelectForm> memoryList = productsDao.getPresetMemoryInfo(preset_id);
        return memoryList;
    }
    public List<MbSelectForm> getPresetMbInfo(int preset_id){
        List<MbSelectForm> mbList = productsDao.getPresetMbInfo(preset_id);
        return mbList;
    }
    public List<SsdSelectForm> getPresetSsdInfo(int preset_id){
        List<SsdSelectForm> ssdList = productsDao.getPresetSsdInfo(preset_id);
        return ssdList;
    }
    public List<PsuSelectForm> getPresetPsuInfo(int preset_id){
        List<PsuSelectForm> psuList = productsDao.getPresetPsuInfo(preset_id);
        return psuList;
    }
    public List<OsSelectForm> getPresetOsInfo(int preset_id){
        List<OsSelectForm> osList = productsDao.getPresetOsInfo(preset_id);
        return osList;
    }
    public List<PresetListFormJs> getPresetDescriptionInfo(int preset_id){
        List<PresetListFormJs> descriptionList = productsDao.getPresetDescriptionInfo(preset_id);
        return descriptionList;
    }

}
