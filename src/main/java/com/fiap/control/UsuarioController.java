package com.fiap.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.fiap.model.Usuario;

@RestController
@RequestMapping("/fastFoodApi/usuario")
@Api(value = "Usuario Controller", description = "Operações relacionadas controle de consumidores e usuários internos.")
public class UsuarioController {

 @Autowired
 private UsuarioRepository usuarioRepository;
 
 @GetMapping("/loginAdm/{cpf}")
 @ApiOperation(value = "Realiza login do usuário interno.")
 public ResponseEntity<Usuario> loginAdm(@PathVariable Usuario loginUsuario) {
     Usuario login = usuarioRepository.existsByCpfAndSenha(loginUsuario.getCpf(), loginUsuario.getSenha());
     if (login != null) {
         return new ResponseEntity<>(login, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
 
 @GetMapping("/{cpf}")
 @ApiOperation(value = "Valida se consumidor já está cadastrado na base.")
 public ResponseEntity<Usuario> buscarClienteCPF(@PathVariable String cpf) {
     Usuario usuario = usuarioRepository.existsByCPF(cpf);
     if (usuario != null) {
         return new ResponseEntity<>(usuario, HttpStatus.OK);
     } else {
    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
 
 @PostMapping
 @ApiOperation(value = "Realiza o cadastro de um novo consumidor.")
 public ResponseEntity<Usuario> criarCategoria(@RequestBody Usuario usuario) {
     Usuario novoUsuario = usuarioRepository.save(usuario);
     return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
 }
}