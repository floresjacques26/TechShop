package com.techshop.service;

import com.techshop.model.Pedido;
import com.techshop.model.Produto;
import com.techshop.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido adicionar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido alterar(Long id, Pedido pedido) {
        if (pedidoRepository.existsById(id)) {
            pedido.setId(id);
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public void remover(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido alterarProdutos(Long id, List<Produto> produtos) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            pedido.setProdutos(produtos);
            return pedidoRepository.save(pedido);
        }
        return null;
    }
}
