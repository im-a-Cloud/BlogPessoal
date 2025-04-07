package com.BlogPessoal.BlogPessoal.Service;

import com.BlogPessoal.BlogPessoal.DTO.CategoriaDTO;
import com.BlogPessoal.BlogPessoal.Entidades.CategoriaClasse;
import com.BlogPessoal.BlogPessoal.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public void salvarModificacoesPostagem(CategoriaClasse categoriaSalva){
        this.categoriaRepository.save(categoriaSalva);
    }
    public CategoriaClasse novaCategoria(CategoriaDTO novaCategoria){
        CategoriaClasse categoriaClasse = new CategoriaClasse(novaCategoria);
        this.salvarModificacoesPostagem(categoriaClasse);
        return  categoriaClasse;
    }
    public List<CategoriaClasse> retornarCategorias(){
        return this.categoriaRepository.findAll();
    }
}
