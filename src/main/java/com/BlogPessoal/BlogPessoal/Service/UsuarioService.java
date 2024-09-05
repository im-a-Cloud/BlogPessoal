package com.BlogPessoal.BlogPessoal.Service;

import com.BlogPessoal.BlogPessoal.DTO.UsuarioDTO;
import com.BlogPessoal.BlogPessoal.Entidades.UsuarioClasse;
import com.BlogPessoal.BlogPessoal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public void salvarModificacoesUsuario(UsuarioClasse novoUsuario){
        this.usuarioRepository.save(novoUsuario);
    }

    public UsuarioClasse criarNovoUsuario(UsuarioDTO novoUsuario){
        UsuarioClasse usuarioClasse = new UsuarioClasse(novoUsuario);
        this.salvarModificacoesUsuario(usuarioClasse);
        return usuarioClasse;
    }
    public List<UsuarioClasse> retornaTodosUsuarios(){
        return this.usuarioRepository.findAll();
    }
}
