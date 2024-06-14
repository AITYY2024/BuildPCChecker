package com.buildpcchecker.buildpcchecker.form;

import lombok.Data;

@Data
public class PresetListForm {

    private int preset_id;

    private String preset_name;

    private int user_id;

    private String cpu_id;

    private String cpu_name;

    private String gpu_id;

    private String gpu_name;

    private String ram_id;

    private String ram_name;

    private String storage_id;

    private String storage_name;

    private String psu_id;

    private String psu_name;

    private int total_amount;
}