package com.buildpcchecker.buildpcchecker.date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompatibleDisplayForm {

    private int id;//互換性テーブルid

    private String cpuGeneration;//cpuの世代

    private String chipsetName;//チップセット名

}
