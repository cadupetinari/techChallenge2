package com.fiap.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.model.Categoria;
import java.util.List;

@RestController
@RequestMapping("/fastFoodApi/categorias")
public class CategoriaController {

 @Autowired
 private CategoriaRepository categoriaRepository;

 @GetMapping
 public List<Categoria> listarCategorias() {
     return categoriaRepository.findAll();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Categoria> obterCategoria(@PathVariable Long id) {
     Categoria categoria = categoriaRepository.findById(id).orElse(null);
     if (categoria != null) {
         return new ResponseEntity<>(categoria, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @PostMapping
 public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
     Categoria novaCategoria = categoriaRepository.save(categoria);
     return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaAtualizada) {
     if (categoriaRepository.existsById(id)) {
         categoriaAtualizada.setId(id);
         Categoria categoriaAtualizadaSalva = categoriaRepository.save(categoriaAtualizada);
         return new ResponseEntity<>(categoriaAtualizadaSalva, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> excluirCategoria(@PathVariable Long id) {
     if (categoriaRepository.existsById(id)) {
         categoriaRepository.deleteById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}