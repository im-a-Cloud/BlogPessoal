package com.BlogPessoal.BlogPessoal.Controller;

import com.BlogPessoal.BlogPessoal.DTO.PostagemDTO;
import com.BlogPessoal.BlogPessoal.Entidades.PostagemClasse;
import com.BlogPessoal.BlogPessoal.Service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Postagem")
public class PostagemController {
    @Autowired
    PostagemService postagemService;
    @GetMapping
    public List<PostagemClasse> retornarPostagens(){
        return postagemService.retornaPostagens();
    }

    @PostMapping
    public ResponseEntity<PostagemClasse> novoPost(@RequestBody PostagemDTO novoPost){
        PostagemClasse postagemClasse = postagemService.novaPostagem(novoPost);
        return new ResponseEntity<>(postagemClasse, HttpStatus.CREATED);
    }
}
