package com.stupendos.calculatordemo.service;

import org.springframework.stereotype.Service;

import static java.lang.Integer.sum;

@Service
public class CalculatorService {
    public Integer plus(Integer num1, Integer num2) {
        return (num1 + num2);
    }
    public Integer minus(Integer num1, Integer num2) {
        return (num1 - num2);
    }
    public Integer multiply(Integer num1, Integer num2) {
        return (num1 * num2);
    }

    public double divide(Integer num1, Integer num2) {
        return (num1 / num2);
    }
}
