package com.fiap.control;

import com.fiap.model.Usuario;
import com.fiap.usecase.UsuarioUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fastFoodApi/usuario")
@Api(value = "Usuário Controller", description = "Operações relacionadas ao controle de consumidores e usuários internos.")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @Autowired
    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @GetMapping("/{cpf}")
    @ApiOperation(value = "Valida se consumidor já está cadastrado na base.")
    public ResponseEntity<Usuario> buscarClienteCPF(@PathVariable String cpf) {
        Usuario usuario = usuarioUseCase.buscarUsuarioPorCPF(cpf);
        return usuario != null ?
                new ResponseEntity<>(usuario, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ApiOperation(value = "Realiza o cadastro de um novo consumidor.")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioUseCase.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }
}