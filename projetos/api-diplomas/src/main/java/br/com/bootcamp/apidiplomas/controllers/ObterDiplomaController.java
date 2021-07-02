package br.com.bootcamp.apidiplomas.controllers;

import br.com.bootcamp.apidiplomas.dto.DiplomaDTO;
import br.com.bootcamp.apidiplomas.entities.Aluno;
import br.com.bootcamp.apidiplomas.entities.Diploma;
import br.com.bootcamp.apidiplomas.services.ObterDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class ObterDiplomaController {

    private final ObterDiplomaService obterDiplomaService;

    @Autowired
    public ObterDiplomaController(ObterDiplomaService obterDiplomaService) {
        this.obterDiplomaService = obterDiplomaService;
    }

    @PostMapping
    public ResponseEntity<DiplomaDTO> gerarDiploma(@RequestBody Aluno aluno) {
        return new ResponseEntity<>(obterDiplomaService.obterDiploma(aluno), HttpStatus.ACCEPTED);
    }
}
