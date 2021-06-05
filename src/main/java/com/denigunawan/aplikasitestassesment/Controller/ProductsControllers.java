package com.denigunawan.aplikasitestassesment.Controller;


import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseProducts;
import com.denigunawan.aplikasitestassesment.Model.Dto.ProductsDto;
import com.denigunawan.aplikasitestassesment.Model.Products;
import com.denigunawan.aplikasitestassesment.Services.Service.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductsControllers {

    @Autowired
    ProductsServices productsServices;

    @PostMapping
    public ApiResponseProducts<Products> saveProducts(@RequestBody ProductsDto productsDto){
        return new ApiResponseProducts<>(HttpStatus.OK.value(), "Products saved successfully.",productsServices.saveProducts(productsDto));
    }

    @GetMapping
    public ApiResponseProducts<List<Products>> listProducts(){
        return new ApiResponseProducts<>(HttpStatus.OK.value(), "Products list fetched successfully.",productsServices.findAllProducts());
    }

    @GetMapping("/{id}")
    public ApiResponseProducts<Products> getOne(@PathVariable Long id){
        return new ApiResponseProducts<>(HttpStatus.OK.value(), "Products fetched successfully.",productsServices.findProductsById(id));
    }

    @PutMapping("/{id}")
    public ApiResponseProducts<ProductsDto> update(@RequestBody ProductsDto ProductsDto) {
        return new ApiResponseProducts<>(HttpStatus.OK.value(), "Products updated successfully.",productsServices.updateProducts(ProductsDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseProducts<Void> delete(@PathVariable Long id) {
        productsServices.deleteProductsById(id);
        return new ApiResponseProducts<>(HttpStatus.OK.value(), "Products deleted successfully.", null);
    }
}
