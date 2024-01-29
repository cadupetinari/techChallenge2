package com.fiap.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.model.Usuario;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
    	System.out.println("CPF: " + usuario.getCpf());
    	
    	Usuario response = usuarioRepository.existsByCPF(usuario.getCpf());
    	
    	if (response != null) {
            return "Que bom ver você de volta, " + response.getNome() +"!";
        } else {
            return "Cliente não identificado!";
        }
    }
}
