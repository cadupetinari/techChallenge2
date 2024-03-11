package com.fiap.usecase;

import com.fiap.model.Categoria;
import com.fiap.control.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaUseCase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria obterCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizarCategoria(Long id, Categoria categoriaAtualizada) {
        if (categoriaRepository.existsById(id)) {
            categoriaAtualizada.setId(id);
            return categoriaRepository.save(categoriaAtualizada);
        } else {
            return null;
        }
    }

    public boolean excluirCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}