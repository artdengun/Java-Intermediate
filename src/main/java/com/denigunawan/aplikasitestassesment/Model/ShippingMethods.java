package com.denigunawan.aplikasitestassesment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipping_methods")
public class ShippingMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_methods_id")
    private Long shippingMethodID;

    @Column(name = "shipping_method", nullable = false, length = 20)
    private String shippingMethod;

    @OneToMany(mappedBy = "shippingMethods")
    private List<Orders> ordersList = new ArrayList<>();
}
