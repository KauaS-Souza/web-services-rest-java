package com.exemplo.webservices.service;

import com.exemplo.webservices.entities.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoService() {
        produtos.add(new Produto(1, "Teclado", 120.00, true));
        produtos.add(new Produto(2, "Mouse", 80.00, true));
        produtos.add(new Produto(3, "Monitor", 850.00, false));
    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto buscarPorId(long id) {
        return produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Produto cadastrar(Produto produto) {
        produtos.add(produto);
        return produto;
    }

}
