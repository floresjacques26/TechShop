
package com.techshop.controller;

import com.techshop.model.Pedido;
import com.techshop.model.Produto;
import com.techshop.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @PostMapping
    public Pedido adicionar(@RequestBody Pedido pedido) {
        return pedidoService.adicionar(pedido);
    }

    @PutMapping("/{id}")
    public Pedido alterar(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.alterar(id, pedido);
    }

    @PutMapping("/{id}/produtos")
    public Pedido alterarProdutos(@PathVariable Long id, @RequestBody List<Produto> produtos) {
        return pedidoService.alterarProdutos(id, produtos);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        pedidoService.remover(id);
    }
}
