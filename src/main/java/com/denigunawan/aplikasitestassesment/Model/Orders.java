package com.denigunawan.aplikasitestassesment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long ordersID;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "costumer_id", nullable = false)
    private Costumers costumers;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "purchase_order_number", nullable = false)
    private String purchaseOrderNumber;

    @Column(name = "ship_date", nullable = false)
    private Date shipDate;

    @ManyToOne
    @JoinColumn(name = "shipping_methods_id", nullable = false)
    private ShippingMethods shippingMethods;

    @Column(name = "freight_charge", nullable = false)
    private BigInteger freightCharge;

    @Column(name = "taxes", nullable = false)
    private BigInteger taxes;

    @Column(name = "payment_received", nullable = false)
    private Boolean paymentReceived;

    @OneToMany(mappedBy = "orders")
    private List<OrdersDetails> ordersDetails = new ArrayList<>();
}
