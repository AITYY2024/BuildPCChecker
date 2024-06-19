package com.buildpcchecker.buildpcchecker.form;

import lombok.Data;

@Data
public class PresetListForm {

    private int preset_id;//id

    private String preset_name;//プリセット名

    private Integer user_id;//ユーザーid


    //cpu
    private String cpu_id;//CPUid

    private String cpu_name;//CPU名

    private String cpu_url;//CPU_URL


    //gpu
    private String gpu_id;//GPUid

    private String gpu_name;//GPU名

    private String gpu_url;//GPU_URL


    //メモリ
    private String ram_id;//メモリid

    private String ram_name;//メモリ名

    private String ram_url;//メモリ_URL


    //マザーボード
    private String mb_id;//マザーボードid

    private String mb_name;//マザーボード名

    private String mb_url;//マザーボードURL


    //ストレージ
    private String ssd_id;//ストレージid

    private String ssd_name;//ストレージ名

    private String ssd_url;//ストレージ_URL


    //電源
    private String psu_id;//電源id

    private String psu_name;//電源名

    private String psu_url;//電源_URL


    //os
    private String os_id;//os_id

    private String os_name;//os名

    private String os_url;//os_URL


    private Integer description;//メモ

    private Integer total_amount;//合計金額aaaaaa

}