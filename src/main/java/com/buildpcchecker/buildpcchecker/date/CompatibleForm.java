package com.buildpcchecker.buildpcchecker.date;

import lombok.Data;

@Data
public class CompatibleForm {

    private int id;//互換性テーブルid

    private String cpu_generation;//cpuの世代

    private String chipset_name;//チップセット名
}
