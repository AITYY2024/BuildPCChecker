package com.buildpcchecker.buildpcchecker.date;

import lombok.Data;

@Data
public class CompatibleForm {

    private int id;

    private String cpu_generation;//cpuの世代

    private String chipset_name;//チップセット名
}
