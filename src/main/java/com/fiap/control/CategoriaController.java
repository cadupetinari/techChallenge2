package com.fiap.control;

import com.fiap.model.Categoria;
import com.fiap.usecase.CategoriaUseCase;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fastFoodApi/categorias")
public class CategoriaController {

    private final CategoriaUseCase categoriaUseCase;

    @Autowired
    public CategoriaController(CategoriaUseCase categoriaUseCase) {
        this.categoriaUseCase = categoriaUseCase;
    }

    @GetMapping
    @ApiOperation("Lista todas as categorias")
    public List<Categoria> listarCategorias() {
        return categoriaUseCase.listarCategorias();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtém uma categoria pelo ID")
    public ResponseEntity<Categoria> obterCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaUseCase.obterCategoria(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ApiOperation("Cria uma nova categoria")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaUseCase.criarCategoria(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza uma categoria pelo ID")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaAtualizada) {
        Categoria categoriaAtualizadaSalva = categoriaUseCase.atualizarCategoria(id, categoriaAtualizada);
        if (categoriaAtualizadaSalva != null) {
            return new ResponseEntity<>(categoriaAtualizadaSalva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui uma categoria pelo ID")
    public ResponseEntity<Void> excluirCategoria(@PathVariable Long id) {
        boolean sucesso = categoriaUseCase.excluirCategoria(id);
        if (sucesso) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}