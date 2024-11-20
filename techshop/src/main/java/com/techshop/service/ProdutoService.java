package com.techshop.service;

import com.techshop.model.Produto;
import com.techshop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto adicionar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto consultarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}
