package com.denigunawan.aplikasitestassesment.Services.Impl;

import com.denigunawan.aplikasitestassesment.Model.Dto.OrdersDetailsDto;
import com.denigunawan.aplikasitestassesment.Model.OrdersDetails;
import com.denigunawan.aplikasitestassesment.Dao.OrdersDetailsDao;
import com.denigunawan.aplikasitestassesment.Services.Service.OrdersDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersDetailsServicesImpl  implements OrdersDetailsServices {

    @Autowired
    OrdersDetailsDao ordersDetailsDao;

    @Override
    public List<OrdersDetails> findAllOrdersDetails() {
        List<OrdersDetails> list = new ArrayList<>();
        ordersDetailsDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public OrdersDetails save(OrdersDetailsDto ordersDetailsDto) {
        OrdersDetails newOrdersDetails = new OrdersDetails();
        newOrdersDetails.setOrderDetailID(ordersDetailsDto.getOrderDetailID());
        newOrdersDetails.setDiscount(ordersDetailsDto.getDiscount());
        newOrdersDetails.setOrders(ordersDetailsDto.getOrders());
        newOrdersDetails.setProducts(ordersDetailsDto.getProducts());
        newOrdersDetails.setQuantity(ordersDetailsDto.getQuantity());
        newOrdersDetails.setUnitPrice(ordersDetailsDto.getUnitPrice());

        return ordersDetailsDao.save(newOrdersDetails);
    }

    @Override
    public OrdersDetails findOrdersDetailsById(Long id) {
        Optional<OrdersDetails> findDetailsOrderById = ordersDetailsDao.findById(id);
        return findDetailsOrderById.isPresent() ?  findDetailsOrderById.get() : null;
    }

    @Override
    public OrdersDetailsDto updateOrdersDetails(OrdersDetailsDto ordersDetailsDto) {
        OrdersDetails ordersDetails = findOrdersDetailsById(ordersDetailsDto.getOrderDetailID());
        if(ordersDetails != null) {
            ordersDetailsDao.save(ordersDetails);
        }
        return ordersDetailsDto;
    }

    @Override
    public void deleteOrdersDetailsById(Long id) {
        ordersDetailsDao.deleteById(id);
    }
}
