package com.denigunawan.aplikasitestassesment.Dao;

import com.denigunawan.aplikasitestassesment.Model.ShippingMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethodsDao extends JpaRepository<ShippingMethods, Long> {
}
