package com.sudojava.mockito.application;

import com.sudojava.mockito.service.CalService;

public class MathService {
    private CalService service;

    public void setService(CalService service) {
        this.service = service;
    }

    public int add(int a, int b) {
        return service.add(a, b);
    }
}
