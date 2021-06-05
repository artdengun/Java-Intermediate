package com.denigunawan.aplikasitestassesment.Config.ExceptionAdvice;


import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseEmployees;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceEmployees<E> {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponseEmployees<E> handleNotFoundException(RuntimeException ex) {
        ApiResponseEmployees<E> apiResponseEmployees = new ApiResponseEmployees<E>(400, "Bad request", null);
        return apiResponseEmployees;
    }

}
