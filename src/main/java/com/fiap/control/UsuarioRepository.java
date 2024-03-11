package com.fiap.control;

import com.fiap.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario existsByCpfAndSenha(String cpf, String senha);

    Usuario existsByCpf(String cpf);
}