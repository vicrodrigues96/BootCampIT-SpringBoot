package br.com.bootcamp.linktracker.controllers;

import br.com.bootcamp.linktracker.dtos.LinkDTO;
import br.com.bootcamp.linktracker.services.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/link")
public class LinksController {

    private LinksService linksService;

    @Autowired
    public LinksController(LinksService linksService) {
        this.linksService = linksService;
    }

    @PostMapping
    public ResponseEntity<LinkDTO> adicionarLink(@RequestBody String url, @RequestHeader String password) {
        return new ResponseEntity<>(linksService.adicionarLink(url, password), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LinkDTO>> listarLinks() {
        return new ResponseEntity<>(linksService.retornaListaLinks(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/redirect/{linkId}")
    @ResponseStatus(HttpStatus.OK)
    public void redirecionar(@PathVariable int linkId, @RequestHeader String password) throws IOException {
        linksService.redirecionar(linkId, password);
    }

    @GetMapping
    @RequestMapping("/metrics/{linkId}")
    public ResponseEntity<LinkDTO> getQtdeAcessos(@PathVariable int linkId) {
        return new ResponseEntity<>(this.linksService.getQtdeAcessos(linkId), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkId) {
        this.linksService.invalidarLin(linkId);
        return new ResponseEntity<>("Link invalidado", HttpStatus.ACCEPTED);
    }
}
