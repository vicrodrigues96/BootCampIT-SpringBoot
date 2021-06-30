package br.com.example.pratica.controllers;

import br.com.example.pratica.models.CodigoMorse;
import br.com.example.pratica.services.ConversorService;
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
