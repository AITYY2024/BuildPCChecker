package com.buildpcchecker.buildpcchecker.form;

import lombok.Data;

import java.util.Date;
@Data
public class PsuSelectForm {
    private int id;
    private String product_id;
    private String url;
    private String product_name;
    private Integer price;
    private String release_date;
    private String capacity;
    private String formfactor;
    private String spec_80plus;
}
