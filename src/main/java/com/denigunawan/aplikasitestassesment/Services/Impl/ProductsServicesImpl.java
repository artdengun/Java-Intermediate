package com.denigunawan.aplikasitestassesment.Services.Impl;

import com.denigunawan.aplikasitestassesment.Model.Dto.ProductsDto;
import com.denigunawan.aplikasitestassesment.Model.Products;
import com.denigunawan.aplikasitestassesment.Dao.ProductsDao;
import com.denigunawan.aplikasitestassesment.Services.Service.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductsServicesImpl  implements ProductsServices {

    @Autowired
    ProductsDao productsDao;

    @Override
    public List<Products> findAllProducts() {
        List<Products> productsList = new ArrayList<>();
        productsDao.findAll().iterator().forEachRemaining(productsList::add);
        return  productsList;
    }

    @Override
    public Products saveProducts(ProductsDto productsDto) {
        Products newProducts = new Products();
        newProducts.setProductID(productsDto.getProductID());
        newProducts.setProductName(productsDto.getProductName());
        newProducts.setUnitPrice(productsDto.getUnitPrice());
        newProducts.setInStock(productsDto.getInStock());

        return  productsDao.save(newProducts);
    }

    @Override
    public Products findProductsById(Long id) {
        Optional<Products> findProductsById = productsDao.findById(id);
        return  findProductsById.isPresent() ? findProductsById.get() : null;
    }

    @Override
    public ProductsDto updateProducts(ProductsDto productsDto) {
        Products products = findProductsById(productsDto.getProductID());
        if(products != null){
            productsDao.save(products);
        }
        return productsDto;
    }

    @Override
    public void deleteProductsById(Long id) {
        productsDao.deleteById(id);
    }
}
