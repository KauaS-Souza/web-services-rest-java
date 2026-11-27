package com.exemplo.webservices.controller;

import com.exemplo.webservices.entities.Produto;
import com.exemplo.webservices.service.ProdutoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/produto",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }
)
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable long id) {

        Produto produto = produtoService.buscarPorId(id);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoService.cadastrar(produto);
    }
}
