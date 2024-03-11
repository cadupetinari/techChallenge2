package com.fiap.usecase;

import com.fiap.control.UsuarioRepository;
import com.fiap.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarUsuarioPorCPF(String cpf) {
        return usuarioRepository.existsByCPF(cpf);
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}