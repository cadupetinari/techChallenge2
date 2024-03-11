package com.fiap.control;

import com.fiap.model.Produto;
import com.fiap.usecase.ProdutoUseCase;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fastFoodApi/produto")
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    @Autowired
    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @GetMapping
    @ApiOperation("Lista todos os produtos")
    public List<Produto> listarProdutos() {
        return produtoUseCase.listarProdutos();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtém um produto pelo ID")
    public ResponseEntity<Produto> obterProduto(@PathVariable Long id) {
        Produto produto = produtoUseCase.obterProduto(id);
        return produto != null ?
                new ResponseEntity<>(produto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ApiOperation("Cria um novo produto")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoUseCase.criarProduto(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um produto pelo ID")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produtoAtualizadoSalvo = produtoUseCase.atualizarProduto(id, produtoAtualizado);
        return produtoAtualizadoSalvo != null ?
                new ResponseEntity<>(produtoAtualizadoSalvo, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um produto pelo ID")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        boolean sucesso = produtoUseCase.excluirProduto(id);
        return sucesso ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
