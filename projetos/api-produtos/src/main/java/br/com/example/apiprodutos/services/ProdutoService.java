package br.com.example.apiprodutos.services;

import br.com.example.apiprodutos.daos.ProdutoDAO;
import br.com.example.apiprodutos.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    public void adicionaProduto(Produto produto) {
        produtoDAO.adicionaProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.getListProdutos();
    }

    public Produto listarProdutoById(String id) {
        return produtoDAO.getProdutoById(id);
    }

    public Produto alteraProduto(Produto produto) {
        return produtoDAO.updateProduto(produto);
    }

    public void deletarProdutoById(String id) {
        produtoDAO.deletarProduto(id);
    }
}
