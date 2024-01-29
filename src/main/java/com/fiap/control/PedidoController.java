package com.fiap.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.model.Pedido;

import java.util.List;

@RestController
@RequestMapping("/fastFoodApi/pedido")
public class PedidoController {

 @Autowired
 private PedidoRepository pedidoRepository;

 @GetMapping
 public List<Pedido> listarPedidos() {
     return pedidoRepository.findAll();
 }

 @PostMapping
 public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
     Pedido novoPedido = pedidoRepository.save(pedido);
     return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
     if (pedidoRepository.existsById(id)) {
         pedidoAtualizado.setId(id);
         Pedido pedidoAtualizadoSalvo = pedidoRepository.save(pedidoAtualizado);
         return new ResponseEntity<>(pedidoAtualizadoSalvo, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
 
 @PutMapping("/status/{id}")
 public ResponseEntity<Pedido> atualizarStatusPedido(@PathVariable Long id, @RequestBody String statusAtualizado){
	 Pedido pedidoParaAtualizar = pedidoRepository.findById(id).orElse(null);
     if (pedidoParaAtualizar != null) {
    	 pedidoParaAtualizar.setStatus(statusAtualizado);
         Pedido pedidoAtualizadoSalvo = pedidoRepository.save(pedidoParaAtualizar);
         return new ResponseEntity<>(pedidoAtualizadoSalvo, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
 
 @PutMapping("/pagamento/{id}")
 public ResponseEntity<Pedido> registrarPagemntoPedido(@PathVariable Long id, @RequestBody String statusPagamento) {
	 
	 // Implementacao Futura - Integração Mercado Pago
	 
	 Pedido pedidoParaAtualizar = pedidoRepository.findById(id).orElse(null);
     if (pedidoParaAtualizar != null) {
    	 pedidoParaAtualizar.setStatusPagamento(statusPagamento);
         Pedido pedidoAtualizadoSalvo = pedidoRepository.save(pedidoParaAtualizar);
         return new ResponseEntity<>(pedidoAtualizadoSalvo, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}