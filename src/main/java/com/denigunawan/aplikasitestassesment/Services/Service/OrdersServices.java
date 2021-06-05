package com.denigunawan.aplikasitestassesment.Services.Service;

import com.denigunawan.aplikasitestassesment.Model.Dto.OrdersDto;
import com.denigunawan.aplikasitestassesment.Model.Orders;

import java.util.List;

public interface OrdersServices {

    List<Orders> findAllOrders();

    Orders save(OrdersDto ordersDto);

    Orders findOrdersById(Long id);

    OrdersDto updateOrders(OrdersDto ordersDto);


    void deleteOrdersById(Long id);
}
