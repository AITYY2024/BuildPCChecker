package com.buildpcchecker.buildpcchecker.form;

import lombok.Data;

@Data
public class PresetListFormJs {

    private int presetId;//id

    private String presetName;//プリセット名

    private Integer userId;//ユーザーid


    //cpu
    private String cpuId;//CPUid

    private String cpuName;//CPU名

    private String cpuUrl;//CPU_URL


    //gpu
    private String gpuId;//GPUid

    private String gpuName;//GPU名

    private String gpuUrl;//GPU_URL


    //メモリ
    private String memoryId;//メモリid

    private String memoryName;//メモリ名

    private String memoryUrl;//メモリ_URL


    //マザーボード
    private String mbId;//マザーボードid

    private String mbName;//マザーボード名

    private String mbUrl;//マザーボードURL


    //ストレージ
    private String ssdId;//ストレージid

    private String ssdName;//ストレージ名

    private String ssdUrl;//ストレージ_URL


    //電源
    private String psuId;//電源id

    private String psuName;//電源名

    private String psuUrl;//電源_URL


    //os
    private String osId;//os_id

    private String osName;//os名

    private String osUrl;//os_URL


    private String description;//メモ

    private Integer totalPrice;//合計金額

}