package com.fiap.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.model.Produto;

import java.util.List;

@RestController
@RequestMapping("/fastFoodApi/produtos")
public class ProdutoController {

 @Autowired
 private ProdutoRepository produtoRepository;

 @GetMapping
 public List<Produto> listarProdutos() {
     return produtoRepository.findAll();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Produto> obterProduto(@PathVariable Long id) {
     Produto produto = produtoRepository.findById(id).orElse(null);
     if (produto != null) {
         return new ResponseEntity<>(produto, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @PostMapping
 public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
     Produto novoProduto = produtoRepository.save(produto);
     return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
     if (produtoRepository.existsById(id)) {
    	 produtoAtualizado.setId(id);
         Produto produtoAtualizadoSalvo = produtoRepository.save(produtoAtualizado);
         return new ResponseEntity<>(produtoAtualizadoSalvo, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
     if (produtoRepository.existsById(id)) {
    	 produtoRepository.deleteById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}