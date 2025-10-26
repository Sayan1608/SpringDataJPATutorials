package com.codingshuttle.jpaTutorial.jpaTuts.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CProductInfo {
    private final String sku;
    private final String title;
    private final BigDecimal price;
}
