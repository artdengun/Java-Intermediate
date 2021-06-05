package com.denigunawan.aplikasitestassesment.Controller;



import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseShipping;
import com.denigunawan.aplikasitestassesment.Model.Dto.ShippingMethodsDto;
import com.denigunawan.aplikasitestassesment.Model.ShippingMethods;
import com.denigunawan.aplikasitestassesment.Services.Service.ShippingMethodsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping")
public class ShippingMethodsControllers {

    @Autowired
    ShippingMethodsServices shippingMethodsServices;

    @PostMapping
    public ApiResponseShipping<ShippingMethods> saveShippingMethods(@RequestBody ShippingMethodsDto shippingMethodsDto){
        return new ApiResponseShipping<>(HttpStatus.OK.value(), "ShippingMethods saved successfully.",shippingMethodsServices.saveShippingMethods(shippingMethodsDto));
    }

    @GetMapping
    public ApiResponseShipping<List<ShippingMethods>> listShippingMethods(){
        return new ApiResponseShipping<>(HttpStatus.OK.value(), "ShippingMethods list fetched successfully.",shippingMethodsServices.findAllShippingMethods());
    }

    @GetMapping("/{id}")
    public ApiResponseShipping<ShippingMethods> getOne(@PathVariable Long id){
        return new ApiResponseShipping<>(HttpStatus.OK.value(), "ShippingMethods fetched successfully.",shippingMethodsServices.findShippingMethodsById(id));
    }

    @PutMapping("/{id}")
    public ApiResponseShipping<ShippingMethodsDto> update(@RequestBody ShippingMethodsDto shippingMethodsDto) {
        return new ApiResponseShipping<>(HttpStatus.OK.value(), "ShippingMethods updated successfully.",shippingMethodsServices.updateShippingMethods(shippingMethodsDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseShipping<Void> delete(@PathVariable Long id) {
        shippingMethodsServices.deleteShippingMethodsById(id);
        return new ApiResponseShipping<>(HttpStatus.OK.value(), "ShippingMethods deleted successfully.", null);
    }
}
