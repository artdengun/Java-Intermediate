package com.denigunawan.aplikasitestassesment.Controller;

import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseOrders;
import com.denigunawan.aplikasitestassesment.Model.Dto.OrdersDto;
import com.denigunawan.aplikasitestassesment.Model.Orders;
import com.denigunawan.aplikasitestassesment.Services.Service.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersControllers {

    @Autowired
    private OrdersServices ordersServices;

    @PostMapping
    public ApiResponseOrders<Orders> saveOrders(@RequestBody OrdersDto ordersDto){
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "Orders saved successfully.",ordersServices.save(ordersDto));
    }

    @GetMapping
    public ApiResponseOrders<List<Orders>> listOrders(){
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "Orders list fetched successfully.",ordersServices.findAllOrders());
    }

    @GetMapping("/{id}")
    public ApiResponseOrders<Orders> getOne(@PathVariable Long id){
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "Orders fetched successfully.",ordersServices.findOrdersById(id));
    }

    @PutMapping("/{id}")
    public ApiResponseOrders<OrdersDto> update(@RequestBody OrdersDto ordersDto) {
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "Orders updated successfully.",ordersServices.updateOrders(ordersDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseOrders<Void> delete(@PathVariable Long id) {
        ordersServices.deleteOrdersById(id);
        return new ApiResponseOrders<>(HttpStatus.OK.value(), "Orders deleted successfully.", null);
    }
}
