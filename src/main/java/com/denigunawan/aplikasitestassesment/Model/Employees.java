package com.denigunawan.aplikasitestassesment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeID;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 50)
    private String lastName;

    @Column(name = "title",nullable = false, length = 50)
    private String title;

    @Column(name = "work_phone", nullable = false, length = 30)
    private String workPhone;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    private List<Orders> ordersList = new ArrayList<>();
}
