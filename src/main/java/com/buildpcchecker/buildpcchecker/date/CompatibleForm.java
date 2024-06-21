package com.buildpcchecker.buildpcchecker.date;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CompatibleForm { //追加、更新用Form

    private int compatibleId;//互換性テーブルid

    @NotBlank
    private String cpuGen;//cpuの世代

    @NotBlank
    private String chipset;//チップセット名

}
