package com.denigunawan.aplikasitestassesment.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@JsonIgnoreProperties(value= {"order_details"})
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id")
    private Long productID;

    @Column(name ="product_name", nullable = false, length = 50)
    private String productName;

    @Column(name ="unit_price", nullable = false, length = 50)
    private BigDecimal unitPrice;

    @Column(name="in_stock")
    private Boolean inStock;

    @OneToMany(mappedBy = "products")
    private List<OrdersDetails> ordersDetails = new ArrayList<>();
 }
