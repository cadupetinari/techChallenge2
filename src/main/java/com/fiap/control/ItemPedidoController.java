package com.fiap.control;

import com.fiap.model.ItemPedido;
import com.fiap.usecase.ItemPedidoUseCase;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fastFoodApi/itemPedido")
public class ItemPedidoController {

    private final ItemPedidoUseCase itemPedidoUseCase;

    @Autowired
    public ItemPedidoController(ItemPedidoUseCase itemPedidoUseCase) {
        this.itemPedidoUseCase = itemPedidoUseCase;
    }

    @GetMapping
    @ApiOperation("Lista todos os itens de pedido")
    public List<ItemPedido> listarItensPedidos() {
        return itemPedidoUseCase.listarItensPedidos();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtém itens de pedido por ID do pedido")
    public ResponseEntity<List<ItemPedido>> obterItensProdutoPorID(@PathVariable Long id) {
        List<ItemPedido> itensPedido = itemPedidoUseCase.obterItensPorIdPedido(id);
        if (itensPedido != null) {
            return new ResponseEntity<>(itensPedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ApiOperation("Cria um novo item de pedido")
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido itemPedido) {
        ItemPedido novoItemPedido = itemPedidoUseCase.criarItemPedido(itemPedido);
        return new ResponseEntity<>(novoItemPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um item de pedido")
    public ResponseEntity<ItemPedido> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedidoAtualizado) {
        ItemPedido itemPedidoAtualizadoSalvo = itemPedidoUseCase.atualizarItemPedido(id, itemPedidoAtualizado);
        if (itemPedidoAtualizadoSalvo != null) {
            return new ResponseEntity<>(itemPedidoAtualizadoSalvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um item de pedido")
    public ResponseEntity<Void> excluirItemPedido(@PathVariable Long id) {
        boolean sucesso = itemPedidoUseCase.excluirItemPedido(id);
        if (sucesso) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}