package com.denigunawan.aplikasitestassesment.Services.Impl;

import com.denigunawan.aplikasitestassesment.Model.Dto.ShippingMethodsDto;
import com.denigunawan.aplikasitestassesment.Model.ShippingMethods;
import com.denigunawan.aplikasitestassesment.Dao.ShippingMethodsDao;
import com.denigunawan.aplikasitestassesment.Services.Service.ShippingMethodsServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ShippingMethodsServicesImpl implements ShippingMethodsServices {

    @Autowired
    ShippingMethodsDao shippingMethodsDao;

    @Override
    public List<ShippingMethods> findAllShippingMethods() {
        List<ShippingMethods> list = new ArrayList<>();
        shippingMethodsDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ShippingMethods saveShippingMethods(ShippingMethodsDto shippingMethodsDto) {

        ShippingMethods newShippingMethods = new ShippingMethods();
        newShippingMethods.setShippingMethodID(shippingMethodsDto.getShippingMethodID());
        newShippingMethods.setShippingMethod(shippingMethodsDto.getShippingMethod());
        return  shippingMethodsDao.save(newShippingMethods);
    }

    @Override
    public ShippingMethods findShippingMethodsById(Long id) {
        Optional<ShippingMethods> optionalShippingMethods = shippingMethodsDao.findById(id);
        return optionalShippingMethods.isPresent() ?  optionalShippingMethods.get() : null;
    }

    @Override
    public ShippingMethodsDto updateShippingMethods(ShippingMethodsDto shippingMethodsDto) {
        ShippingMethods shippingMethods = findShippingMethodsById(shippingMethodsDto.getShippingMethodID());
        if(shippingMethods != null) {
            shippingMethodsDao.save(shippingMethods);
        }
        return shippingMethodsDto;
    }

    @Override
    public void deleteShippingMethodsById(Long id) {
        shippingMethodsDao.deleteById(id);
    }
}
