package com.denigunawan.aplikasitestassesment.Config.ExceptionAdvice;


import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseCostumers;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceCostumers<C> {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponseCostumers<C> handleNotFoundException(RuntimeException ex) {
        ApiResponseCostumers<C> apiResponseCostumers = new ApiResponseCostumers<C>(400, "Bad request", null);
        return apiResponseCostumers;
    }

}
