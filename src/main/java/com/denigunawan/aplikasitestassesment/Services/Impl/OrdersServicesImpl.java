package com.denigunawan.aplikasitestassesment.Services.Impl;

import com.denigunawan.aplikasitestassesment.Model.Dto.OrdersDto;
import com.denigunawan.aplikasitestassesment.Model.Orders;
import com.denigunawan.aplikasitestassesment.Dao.OrdersDao;
import com.denigunawan.aplikasitestassesment.Services.Service.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersServicesImpl implements OrdersServices {

    @Autowired
    OrdersDao ordersDao;


    @Override
    public List<Orders> findAllOrders() {

        List<Orders> ordersList = new ArrayList<>();
        ordersDao.findAll().iterator().forEachRemaining(ordersList::add);
        return ordersList;
    }

    @Override
    public Orders save(OrdersDto ordersDto) {
        Orders newOrders = new Orders();

        newOrders.setOrdersID(ordersDto.getOrdersID());
        newOrders.setCostumers(ordersDto.getCostumers());
        newOrders.setEmployees(ordersDto.getEmployees());
        newOrders.setFreightCharge(ordersDto.getFreightCharge());
        newOrders.setOrderDate(ordersDto.getOrderDate());
        newOrders.setPaymentReceived(ordersDto.getPaymentReceived());
        newOrders.setPurchaseOrderNumber(ordersDto.getPurchaseOrderNumber());
        newOrders.setShipDate(ordersDto.getShipDate());
        newOrders.setShippingMethods(ordersDto.getShippingMethods());
        newOrders.setTaxes(ordersDto.getTaxes());

        return ordersDao.save(newOrders);
    }

    @Override
    public Orders findOrdersById(Long id) {
        Optional<Orders> findOrdersById = ordersDao.findById(id);
        return findOrdersById.isPresent() ?  findOrdersById.get() : null;
    }

    @Override
    public OrdersDto updateOrders(OrdersDto ordersDto) {
        Orders orders = findOrdersById(ordersDto.getOrdersID());
        if(orders != null){
            ordersDao.save(orders);
        }
        return ordersDto;

    }

    @Override
    public void deleteOrdersById(Long id) {
        ordersDao.deleteById(id);
    }
}
