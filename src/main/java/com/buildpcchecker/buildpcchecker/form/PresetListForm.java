package com.buildpcchecker.buildpcchecker.form;

import lombok.Data;

@Data
public class PresetListForm {

    private int preset_id;//id

    private String preset_name;//プリセット名

    private Integer user_id;//ユーザーid

    private String cpu_id;//CPUid

    private String cpu_name;//CPU名

    private String gpu_id;//GPUid

    private String gpu_name;//GPU名

    private String ram_id;//メモリid

    private String ram_name;//メモリ名

    private String ssd_id;//ストレージid

    private String ssd_name;//ストレージ名

    private String psu_id;//電源id

    private String psu_name;//電源名

    private Integer total_amount;//合計金額
}