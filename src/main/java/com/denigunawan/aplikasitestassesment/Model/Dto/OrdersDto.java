package com.denigunawan.aplikasitestassesment.Model.Dto;

import com.denigunawan.aplikasitestassesment.Model.Costumers;
import com.denigunawan.aplikasitestassesment.Model.Employees;
import com.denigunawan.aplikasitestassesment.Model.ShippingMethods;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class OrdersDto {

    private Long ordersID;
    private Employees employees;
    private Costumers costumers;
    private Date orderDate;
    private String purchaseOrderNumber;
    private Date shipDate;
    private ShippingMethods shippingMethods;
    private BigInteger freightCharge;
    private BigInteger taxes;
    private Boolean paymentReceived;
}
