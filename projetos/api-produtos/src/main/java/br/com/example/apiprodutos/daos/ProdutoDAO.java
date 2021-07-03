package br.com.example.apiprodutos.daos;

import br.com.example.apiprodutos.entities.Produto;
import br.com.example.apiprodutos.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoDAO {

    private static List<Produto> produtos = new ArrayList<>();

    public List<Produto> getListProdutos() {
        return produtos;
    }

    public Produto getProdutoById(String id) {
        Optional<Produto> produto = produtos.stream().filter(p -> p.getCodigo() == id).findFirst();

        if (Objects.isNull(produto)) {
            throw new NotFoundException("Produto não encontrado");
        }

        return produto.get();
    }

    public void adicionaProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto updateProduto(Produto produto) {
        int indice = 0;

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equals(produto.getCodigo())) {
                indice = i;
            }
        }

        produtos.add(indice, produto);
        //irá remover o proximo produto da lista
        produtos.remove(indice + 1);
        return produto;
    }

    public void deletarProduto(String codigo) {
        produtos.removeIf(p -> p.getCodigo().equals(codigo));
    }
}
