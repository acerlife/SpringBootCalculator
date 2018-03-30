package com.makhnov.springbootcalculator.controller;

import com.makhnov.springbootcalculator.dao.CalculatorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorController {
    @Autowired
   private CalculatorDao calculatorDao;

    @GetMapping("/{string}")
    public @ResponseBody void saveResult(@PathVariable String string) throws Exception{
        calculatorDao.saveResult(string);
    }
}
