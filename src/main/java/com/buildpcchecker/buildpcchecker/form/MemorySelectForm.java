package com.buildpcchecker.buildpcchecker.form;

import lombok.Data;

import java.util.Date;

@Data
public class MemorySelectForm {
    private int id;
    private String product_id;
    private String url;
    private String product_name;
    private Integer price;
    private Date release_date;
    private String capacity;
    private String count;
    private String spec;
}
