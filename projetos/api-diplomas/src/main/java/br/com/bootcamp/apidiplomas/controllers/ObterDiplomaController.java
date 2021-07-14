package br.com.bootcamp.apidiplomas.controllers;

import br.com.bootcamp.apidiplomas.dto.AlunoDTO;
import br.com.bootcamp.apidiplomas.dto.DiplomaDTO;
import br.com.bootcamp.apidiplomas.services.ObterDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class ObterDiplomaController {

    private final ObterDiplomaService obterDiplomaService;

    @Autowired
    public ObterDiplomaController(ObterDiplomaService obterDiplomaService) {
        this.obterDiplomaService = obterDiplomaService;
    }

    @PostMapping
    public ResponseEntity<DiplomaDTO> gerarDiploma(@Valid @RequestBody AlunoDTO alunoDto) {
        return new ResponseEntity<>(obterDiplomaService.obterDiploma(alunoDto), HttpStatus.CREATED);
    }
}
