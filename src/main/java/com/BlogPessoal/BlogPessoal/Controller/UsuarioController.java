package com.BlogPessoal.BlogPessoal.Controller;

import com.BlogPessoal.BlogPessoal.DTO.UsuarioDTO;
import com.BlogPessoal.BlogPessoal.Entidades.UsuarioClasse;
import com.BlogPessoal.BlogPessoal.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
@CrossOrigin(origins = "http://localhost:4200") // Permite requests do Angular

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioClasse> criarUsuario(@RequestBody UsuarioDTO novoUsuario ){
        UsuarioClasse usuarioClasse = usuarioService.criarNovoUsuario(novoUsuario);
        return new ResponseEntity<>(usuarioClasse, HttpStatus.CREATED);
    }
    @GetMapping

    public List<UsuarioClasse> retornarUsuarios(){
        return usuarioService.retornaTodosUsuarios();
    }
}