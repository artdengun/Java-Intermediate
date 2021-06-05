package com.denigunawan.aplikasitestassesment.Dao;

import com.denigunawan.aplikasitestassesment.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Long> {
}
