package com.denigunawan.aplikasitestassesment.Dao;

import com.denigunawan.aplikasitestassesment.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsDao extends JpaRepository<Products, Long> {
}
