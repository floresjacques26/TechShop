package com.techshop.controller;

import com.techshop.model.Produto;
import com.techshop.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return produtoService.adicionar(produto);
    }

    @GetMapping("/{id}")
    public Produto consultarPorId(@PathVariable Long id) {
        return produtoService.consultarPorId(id);
    }
}
