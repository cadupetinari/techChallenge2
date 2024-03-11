package com.fiap.usecase;

import com.fiap.control.ItemPedidoRepository;
import com.fiap.model.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemPedidoUseCase {

    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public ItemPedidoUseCase(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> listarItensPedidos() {
        return itemPedidoRepository.findAll();
    }

    public List<ItemPedido> obterItensPorIdPedido(Long idPedido) {
        return itemPedidoRepository.existsByIdPedido(idPedido);
    }

    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido atualizarItemPedido(Long id, ItemPedido itemPedidoAtualizado) {
        if (itemPedidoRepository.existsById(id)) {
            itemPedidoAtualizado.setId(id);
            return itemPedidoRepository.save(itemPedidoAtualizado);
        } else {
            return null;
        }
    }

    public boolean excluirItemPedido(Long id) {
        if (itemPedidoRepository.existsById(id)) {
            itemPedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}