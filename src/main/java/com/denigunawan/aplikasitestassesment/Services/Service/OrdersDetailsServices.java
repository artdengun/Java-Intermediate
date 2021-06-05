package com.denigunawan.aplikasitestassesment.Services.Service;

import com.denigunawan.aplikasitestassesment.Model.Dto.OrdersDetailsDto;
import com.denigunawan.aplikasitestassesment.Model.OrdersDetails;

import java.util.List;

public interface OrdersDetailsServices {

    List<OrdersDetails> findAllOrdersDetails();

    OrdersDetails save(OrdersDetailsDto ordersDetailsDto);

    OrdersDetails findOrdersDetailsById(Long id);

    OrdersDetailsDto updateOrdersDetails(OrdersDetailsDto ordersDetailsDto);

    void deleteOrdersDetailsById(Long id);
}
