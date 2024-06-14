package com.buildpcchecker.buildpcchecker.form;

import lombok.Data;

@Data
public class CpuSelectForm {
    private int id;
    private String product_id;
    private String url;
    private String product_name;
    private Integer price;
    private String release_date;
    private String core;
    private String freq;
    private String socket;
    private String gen;

}
