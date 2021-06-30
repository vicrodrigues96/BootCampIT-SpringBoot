package com.example.codigomorse.controllers;

import com.example.codigomorse.models.CodigoMorse;
import com.example.codigomorse.services.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/converter")
public class MorseToString {

    @Autowired
    private ConversorService conversorService;

    @PostMapping("/morse")
    @ResponseBody
    public String morse(@RequestBody CodigoMorse codigoMorse) {
        System.out.println(codigoMorse.getCodigoMorse());
        return conversorService.conversor(codigoMorse.getCodigoMorse());
    }
}