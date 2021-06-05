package com.denigunawan.aplikasitestassesment.Model.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductsDto {

    private Long productID;
    private String productName;
    private BigDecimal unitPrice;
    private Boolean inStock;

}
