package br.com.bootcamp.calculadoraidade.controller;

import br.com.bootcamp.calculadoraidade.service.CalculadoraIdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/calculadora")
public class CalculadoraIdadeController {

    private final CalculadoraIdadeService calculadoraIdadeService;

    @Autowired
    public CalculadoraIdadeController(CalculadoraIdadeService calculadoraIdadeService) {
        this.calculadoraIdadeService = calculadoraIdadeService;
    }

    @GetMapping("/idade/{data}")
    public ResponseEntity<Integer> calculaIdade(@PathVariable("data") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data) {
        System.out.println(data);
        int diffBetweenDates = calculadoraIdadeService.calculaData(data);
        return new ResponseEntity<>(diffBetweenDates, HttpStatus.OK);
    }
}
