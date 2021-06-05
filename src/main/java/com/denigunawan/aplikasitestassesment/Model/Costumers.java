package com.denigunawan.aplikasitestassesment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "costumers")
public class Costumers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costumer_id")
    private Long costumerID;

    @Column(name = "company_name",nullable = false, length = 50)
    private String CompanyName;

    @Column(name = "first_name",  nullable = false, length = 30)
    private String FirstName;

    @Column(name = "last_name",  nullable = false, length = 50)
    private String LastName;

    @Column(name = "billing_address",  nullable = false)
    private String BillingAddress;

    @Column(name = "city",  nullable = false, length = 50)
    private String City;

    @Column(name = "state_or_province",  nullable = false, length = 20)
    private String StateOrProvince;

    @Column(name = "zip_code",  nullable = false, length = 20)
    private Long ZipCode;

    @Column(name = "email",  nullable = false, length = 75)
    private String Email;

    @Column(name = "company_website",  nullable = false, length = 200)
    private String CompanyWebsite;

    @Column(name = "phone_number",  nullable = false, length = 30)
    private Long PhoneNumber;

    @Column(name = "fax_number",  nullable = false, length = 30)
    private Long FaxNumber;

    @Column(name = "ship_address",  nullable = false)
    private String ShipAddress;

    @Column(name = "ship_city",  nullable = false, length = 50)
    private String ShipCity;

    @Column(name = "ship_state_or_province",  nullable = false, length = 50)
    private String ShipStateOrProvince;

    @Column(name = "ship_zip_code",  nullable = false, length = 20)
    private Long ShipZipCode;

    @Column(name = "ship_phone_number",  nullable = false, length = 30)
    private Long ShipPhoneNumber;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    private List<Orders> ordersList = new ArrayList<>();

}
