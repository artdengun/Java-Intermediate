package com.denigunawan.aplikasitestassesment.Config.ExceptionAdvice;


import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseShipping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceShipping<S> {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponseShipping<S> handleNotFoundException(RuntimeException ex) {
        ApiResponseShipping<S> apiResponseShipping = new ApiResponseShipping<S>(400, "Bad request", null);
        return apiResponseShipping;
    }

}
