package com.denigunawan.aplikasitestassesment.Model.Dto;

import lombok.Data;

@Data
public class CostumersDto {

    private Long costumerID;
    private String CompanyName;
    private String FirstName;
    private String LastName;
    private String BillingAddress;
    private String City;
    private String StateOrProvince;
    private Long ZipCode;
    private String Email;
    private String CompanyWebsite;
    private Long PhoneNumber;
    private Long FaxNumber;
    private String ShipAddress;
    private String ShipCity;
    private String ShipStateOrProvince;
    private Long ShipZipCode;
    private Long ShipPhoneNumber;

}
