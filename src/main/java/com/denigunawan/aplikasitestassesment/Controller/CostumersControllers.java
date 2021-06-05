package com.denigunawan.aplikasitestassesment.Controller;

import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseCostumers;
import com.denigunawan.aplikasitestassesment.Model.Costumers;
import com.denigunawan.aplikasitestassesment.Model.Dto.CostumersDto;
import com.denigunawan.aplikasitestassesment.Services.Service.CostumersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/costumers")
public class CostumersControllers {

    @Autowired
    private CostumersServices costumersServices;

    @PostMapping
    public ApiResponseCostumers<Costumers> saveCostumers(@RequestBody CostumersDto costumers){
        return new ApiResponseCostumers<>(HttpStatus.OK.value(), "Costumers saved successfully.",costumersServices.save(costumers));
    }

    @GetMapping
    public ApiResponseCostumers<List<Costumers>> listCostumers(){
        return new ApiResponseCostumers<>(HttpStatus.OK.value(), "Costumers list fetched successfully.",costumersServices.findAllCostumers());
    }

    @GetMapping("/{id}")
    public ApiResponseCostumers<Costumers> getOne(@PathVariable Long id){
        return new ApiResponseCostumers<>(HttpStatus.OK.value(), "Costumers fetched successfully.",costumersServices.findCostumersById(id));
    }

    @PutMapping("/{id}")
    public ApiResponseCostumers<CostumersDto> update(@RequestBody CostumersDto costumersDto) {
        return new ApiResponseCostumers<>(HttpStatus.OK.value(), "Costumers updated successfully.",costumersServices.updateCostumers(costumersDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseCostumers<Void> delete(@PathVariable Long id) {
        costumersServices.deleteCostumersById(id);
        return new ApiResponseCostumers<>(HttpStatus.OK.value(), "Costumers deleted successfully.", null);
    }
}
