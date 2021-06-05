package com.denigunawan.aplikasitestassesment.Model.Dto;

import com.denigunawan.aplikasitestassesment.Model.Orders;
import com.denigunawan.aplikasitestassesment.Model.Products;
import lombok.Data;

import java.math.BigInteger;

@Data
public class OrdersDetailsDto {

    private Long orderDetailID;
    private Long quantity;
    private BigInteger unitPrice;
    private BigInteger Discount;
    private Orders orders;
    private Products products;

}
