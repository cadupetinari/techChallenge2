package com.fiap.control;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fiap.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	// Teste para conectar no banco
    //@Query("SELECT u FROM dados_usuario u WHERE u.username = :username AND u.senha = :senha")
    //Usuario existsByUsernameAndSenha(@Param("username") String usernameOrEmail, @Param("senha") String senha);
	
	//Login ADM
	@Query("SELECT u FROM dados_usuario u WHERE u.cpf = :cpf AND u.senha = :senha")
    Usuario existsByCpfAndSenha(@Param("cpf") String cpf, @Param("senha") String senha);	
	
	// Consultar usuário ppr CPF
    @Query("SELECT u FROM dados_usuario u WHERE u.cpf = :cpf")
    Usuario existsByCPF(@Param("cpf") String cpf);
}