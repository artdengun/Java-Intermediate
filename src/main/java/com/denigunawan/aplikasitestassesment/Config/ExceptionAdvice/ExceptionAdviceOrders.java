package com.denigunawan.aplikasitestassesment.Config.ExceptionAdvice;


import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseOrders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceOrders<O> {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponseOrders<O> handleNotFoundException(RuntimeException ex) {
        ApiResponseOrders<O> apiResponseOrders = new ApiResponseOrders<O>(400, "Bad request", null);
        return apiResponseOrders;
    }

}
