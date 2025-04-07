package com.BlogPessoal.BlogPessoal.Controller;

import com.BlogPessoal.BlogPessoal.DTO.CategoriaDTO;
import com.BlogPessoal.BlogPessoal.DTO.PostagemDTO;
import com.BlogPessoal.BlogPessoal.Entidades.CategoriaClasse;
import com.BlogPessoal.BlogPessoal.Entidades.PostagemClasse;
import com.BlogPessoal.BlogPessoal.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Categoria")

public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    @GetMapping
    public List<CategoriaClasse> listarCategorias(){
        return categoriaService.retornarCategorias();
    }
    @PostMapping
    public ResponseEntity<CategoriaClasse> novoPost(@RequestBody CategoriaDTO novaCategoria){
        CategoriaClasse categoriaClasse = categoriaService.novaCategoria(novaCategoria);
        return new ResponseEntity<>(categoriaClasse, HttpStatus.CREATED);
    }
}
