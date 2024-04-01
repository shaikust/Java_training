package com.ust.springboot.demoOnSpringboot.controller;

import com.ust.springboot.demoOnSpringboot.service.ClaculatorService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/calculator")
@Validated
public class ClaculatorController {
    @Autowired
    private ClaculatorService claculatorService;
    @GetMapping("/add")
    public int add(@RequestParam @NotNull int num1,
                   @RequestParam @NotNull int num2) {
        return claculatorService.add(num1,num2);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam  int num1,
                        @RequestParam  int num2) {
        return claculatorService.subtract(num1, num2);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam @NotNull int num1,
                        @RequestParam @NotNull int num2) {
        return claculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public int divide(@RequestParam @NotNull int num1,
                      @RequestParam @NotNull int num2) {
        return claculatorService.divide(num1, num2);
    }
}
