package com.BlogPessoal.BlogPessoal.Controller;

import com.BlogPessoal.BlogPessoal.DTO.AutenticacaoDTO;
import com.BlogPessoal.BlogPessoal.DTO.UsuarioDTO;
import com.BlogPessoal.BlogPessoal.Entidades.UsuarioClasse;
import com.BlogPessoal.BlogPessoal.Repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private static final Logger logger = LoggerFactory.getLogger(AutenticacaoController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid AutenticacaoDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.emailUsuario(), data.usuarioSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody @Valid UsuarioDTO novoUsuario) {
        logger.info("Tentativa de cadastro para o usuário: {}", novoUsuario.emailUsuario());

        if (this.usuarioRepository.findByEmailUsuario(novoUsuario.emailUsuario()) != null) {
            logger.warn("Cadastro falhou: email já existe {}", novoUsuario.emailUsuario());
            return ResponseEntity.badRequest().build();
        }

        String senhaCriptografada = new BCryptPasswordEncoder().encode(novoUsuario.senhaUsuario());
        UsuarioClasse usuarioClasse = new UsuarioClasse(novoUsuario.nomeUsuario(), novoUsuario.emailUsuario(), senhaCriptografada, novoUsuario.tipoUsuario());

        this.usuarioRepository.save(usuarioClasse);
        logger.info("Usuário cadastrado com sucesso: {}", novoUsuario.emailUsuario());

        return ResponseEntity.ok().build();
    }
}