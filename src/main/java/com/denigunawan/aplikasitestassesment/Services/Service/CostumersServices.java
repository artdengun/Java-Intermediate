package com.denigunawan.aplikasitestassesment.Services.Service;

import com.denigunawan.aplikasitestassesment.Model.Costumers;
import com.denigunawan.aplikasitestassesment.Model.Dto.CostumersDto;

import java.util.List;

public interface CostumersServices {

    List<Costumers> findAllCostumers();

    Costumers save(CostumersDto costumers);

    Costumers findCostumersById(Long id);

    CostumersDto updateCostumers(CostumersDto costumersDto);

    void deleteCostumersById(Long id);

}
