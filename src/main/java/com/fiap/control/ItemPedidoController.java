package com.fiap.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.model.ItemPedido;
import com.fiap.model.Produto;

import java.util.List;

@RestController
@RequestMapping("/fastFoodApi/itemPedido")
public class ItemPedidoController {

 @Autowired
 private ItemPedidoRepository itemPedidoRepository;

 @GetMapping
 public List<ItemPedido> listarItensPedidos() {
     return itemPedidoRepository.findAll();
 }
 
 @GetMapping("/{id}")
 public List<ItemPedido> obterItensProdutoPorID(@PathVariable Long id) {
	 List<ItemPedido> itensProduto = itemPedidoRepository.existsByIdPedido(id);
     if (itensProduto != null) {
         return itensProduto;
     } else {
         return null;
     }
 }

 @PostMapping
 public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido itemPedido) {
     ItemPedido novoItemPedido = itemPedidoRepository.save(itemPedido);
     return new ResponseEntity<>(novoItemPedido, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<ItemPedido> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedidoAtualizado) {
     if (itemPedidoRepository.existsById(id)) {
         itemPedidoAtualizado.setId(id);
         ItemPedido itemPedidoAtualizadoSalvo = itemPedidoRepository.save(itemPedidoAtualizado);
         return new ResponseEntity<>(itemPedidoAtualizadoSalvo, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> excluirItemPedido(@PathVariable Long id) {
     if (itemPedidoRepository.existsById(id)) {
         itemPedidoRepository.deleteById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}