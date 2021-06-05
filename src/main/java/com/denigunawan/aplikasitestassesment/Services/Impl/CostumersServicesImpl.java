package com.denigunawan.aplikasitestassesment.Services.Impl;

import com.denigunawan.aplikasitestassesment.Dao.CostumersDao;
import com.denigunawan.aplikasitestassesment.Model.Costumers;
import com.denigunawan.aplikasitestassesment.Model.Dto.CostumersDto;
import com.denigunawan.aplikasitestassesment.Services.Service.CostumersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CostumersServicesImpl  implements CostumersServices {

    @Autowired
    private CostumersDao costumersDao;

    @Override
    public List<Costumers> findAllCostumers() {
        List<Costumers> list = new ArrayList<>();
        costumersDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Costumers save(CostumersDto costumers) {
        Costumers newCostumers = new Costumers();
        newCostumers.setCostumerID(costumers.getCostumerID());
        newCostumers.setFirstName(costumers.getFirstName());
        newCostumers.setLastName(costumers.getLastName());
        newCostumers.setBillingAddress(costumers.getBillingAddress());
        newCostumers.setCity(costumers.getCity());
        newCostumers.setZipCode(costumers.getZipCode());
        newCostumers.setCompanyName(costumers.getCompanyName());
        newCostumers.setCompanyWebsite(costumers.getCompanyWebsite());
        newCostumers.setEmail(costumers.getEmail());
        newCostumers.setStateOrProvince(costumers.getStateOrProvince());
        newCostumers.setFaxNumber(costumers.getFaxNumber());
        newCostumers.setPhoneNumber(costumers.getPhoneNumber());
        newCostumers.setShipAddress(costumers.getShipAddress());
        newCostumers.setShipCity(costumers.getShipCity());
        newCostumers.setShipPhoneNumber(costumers.getShipPhoneNumber());
        newCostumers.setShipStateOrProvince(costumers.getShipStateOrProvince());
        newCostumers.setShipZipCode(costumers.getShipZipCode());

        return costumersDao.save(newCostumers);
    }

    @Override
    public Costumers findCostumersById(Long id) {
        Optional<Costumers> optionalCostumers = costumersDao.findById(id);
        return optionalCostumers.isPresent() ?  optionalCostumers.get() : null;
    }

    @Override
    public CostumersDto updateCostumers(CostumersDto costumersDto) {
        Costumers costumers = findCostumersById(costumersDto.getCostumerID());
        if(costumers != null) {
            costumersDao.save(costumers);
        }
        return costumersDto;
    }

    @Override
    public void deleteCostumersById(Long id) {
        costumersDao.deleteById(id);
    }

}
