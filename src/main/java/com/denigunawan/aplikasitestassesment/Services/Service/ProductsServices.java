package com.denigunawan.aplikasitestassesment.Services.Service;

import com.denigunawan.aplikasitestassesment.Model.Dto.ProductsDto;
import com.denigunawan.aplikasitestassesment.Model.Products;

import java.util.List;

public interface ProductsServices {

    List<Products> findAllProducts();

    Products saveProducts(ProductsDto productsDto);

    Products findProductsById(Long id);

    ProductsDto updateProducts(ProductsDto productsDto);

    void deleteProductsById(Long id);
}
