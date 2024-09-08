package com.stupendos.calculatordemo.calculator.controller;
import com.stupendos.calculatordemo.exception.DivideByZeroException;
import com.stupendos.calculatordemo.exception.NullParametersException;
import com.stupendos.calculatordemo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class HelloController {

    private final CalculatorService service;

    public HelloController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        validateParams(num1, num2);
        return num1 + " + " + num2 + " = " + service.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        validateParams(num1, num2);
        return num1 + " - " + num2 + " = " + service.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        validateParams(num1, num2);
        return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num2 == 0) {
            throw new DivideByZeroException("Ошибка при делении на ноль");
        }
        validateParams(num1, num2);
        return num1 + " / " + num2 + " = " + service.divide(num1, num2);
    }

    private void validateParams(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NullParametersException("Ошибка");
        }
    }
}
