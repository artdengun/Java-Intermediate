package com.denigunawan.aplikasitestassesment.Config.ExceptionAdvice;


import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseProducts;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceProducts<P> {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponseProducts<P> handleNotFoundException(RuntimeException ex) {
        ApiResponseProducts<P> apiResponseProducts = new ApiResponseProducts<P>(400, "Bad request", null);
        return apiResponseProducts;
    }

}
