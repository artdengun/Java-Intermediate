package com.denigunawan.aplikasitestassesment.Services.Service;

import com.denigunawan.aplikasitestassesment.Model.Dto.ShippingMethodsDto;
import com.denigunawan.aplikasitestassesment.Model.ShippingMethods;

import java.util.List;

public interface ShippingMethodsServices {

    List<ShippingMethods> findAllShippingMethods();

    ShippingMethods saveShippingMethods(ShippingMethodsDto shippingMethodsDto);

    ShippingMethods findShippingMethodsById(Long id);

    ShippingMethodsDto updateShippingMethods(ShippingMethodsDto shippingMethodsDto);

    void deleteShippingMethodsById(Long id);
}
