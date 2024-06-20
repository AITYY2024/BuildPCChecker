package com.buildpcchecker.buildpcchecker.date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompatibleForm {

    private int compatibleId;//互換性テーブルid

    private String cpuGen;//cpuの世代

    private String chipset;//チップセット名

}
