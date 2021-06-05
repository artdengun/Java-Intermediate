package com.denigunawan.aplikasitestassesment.Dao;

import com.denigunawan.aplikasitestassesment.Model.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailsDao extends JpaRepository<OrdersDetails, Long> {
}
