package com.denigunawan.aplikasitestassesment.Controller;

import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseOrders;
import com.denigunawan.aplikasitestassesment.Model.Dto.OrdersDetailsDto;
import com.denigunawan.aplikasitestassesment.Model.Dto.OrdersDto;
import com.denigunawan.aplikasitestassesment.Model.Orders;
import com.denigunawan.aplikasitestassesment.Model.OrdersDetails;
import com.denigunawan.aplikasitestassesment.Services.Service.OrdersDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders/details")
public class OrdersDetailsControllers {

    @Autowired
    private OrdersDetailsServices ordersDetailsServices;


    @PostMapping
    public ApiResponseOrders<OrdersDetails> saveOrdersDetails(@RequestBody OrdersDetailsDto ordersDetailsDto){
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "OrdersDetails saved successfully.",ordersDetailsServices.save(ordersDetailsDto));
    }

    @GetMapping
    public ApiResponseOrders<List<OrdersDetails>> listOrdersDetails(){
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "OrdersDetails list fetched successfully.",ordersDetailsServices.findAllOrdersDetails());
    }

    @GetMapping("/{id}")
    public ApiResponseOrders<Orders> getOne(@PathVariable Long id){
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "OrdersDetails fetched successfully.",ordersDetailsServices.findOrdersDetailsById(id));
    }

    @PutMapping("/{id}")
    public ApiResponseOrders<OrdersDto> update(@RequestBody OrdersDetailsDto ordersDetailsDto) {
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "Orders updated successfully.",ordersDetailsServices.updateOrdersDetails(ordersDetailsDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseOrders<Void> delete(@PathVariable Long id) {
        ordersDetailsServices.deleteOrdersDetailsById(id);
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "Orders deleted successfully.", null);
    }
}
