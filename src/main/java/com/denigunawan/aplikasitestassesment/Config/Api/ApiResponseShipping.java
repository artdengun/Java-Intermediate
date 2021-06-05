package com.denigunawan.aplikasitestassesment.Config.Api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseShipping<S> {
    private int status;
    private String message;
    private Object result;
}
