package br.com.example.apiprodutos.controllers;
import br.com.example.apiprodutos.entities.Produto;
import br.com.example.apiprodutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/lista")
    @ResponseBody
    public List<Produto> consultarProdutos() {
        return produtoService.listarProdutos();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Produto> cadastra(@RequestBody Produto produto, UriComponentsBuilder uriBuilder) {
        produtoService.adicionaProduto(produto);
        URI uri = uriBuilder.path("produtos/{id}").buildAndExpand(produto.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleta(@PathVariable String id) {
        System.out.println("passou" + id);
        produtoService.deletarProdutoById(id);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.alteraProduto(produto), HttpStatus.OK);
    }
}
