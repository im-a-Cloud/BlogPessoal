package com.BlogPessoal.BlogPessoal.Service;

import com.BlogPessoal.BlogPessoal.DTO.PostagemDTO;
import com.BlogPessoal.BlogPessoal.Entidades.PostagemClasse;
import com.BlogPessoal.BlogPessoal.Entidades.UsuarioClasse;
import com.BlogPessoal.BlogPessoal.Repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository){
        this.postagemRepository = postagemRepository;
    }

    public void salvarModificacoesPostagem(PostagemClasse postagemSalva){
        this.postagemRepository.save(postagemSalva);
    }

    public PostagemClasse novaPostagem(PostagemDTO novoPost){
        PostagemClasse postagemClasse =  new PostagemClasse(novoPost);
        this.salvarModificacoesPostagem(postagemClasse);
        return postagemClasse;
    }

/*
    public String apagarPost(long idPostagem){
        Optional<PostagemClasse> postApagar = this.postagemRepository.findById(idPostagem);
        if (postApagar.isPresent()) {
            this.postagemRepository.delete(postApagar.get());
            return "Postagem apagada com sucesso!";
        } else {
            return "Erro: Postagem não encontrada!";
        }
    }
    public PostagemClasse editarPostagem(PostagemDTO postEditado){
        PostagemClasse postagemClasse = editarPostagem(postEditado);
        this.postagemRepository.save(postagemClasse);
        return postagemClasse;
    }

 */
    public List<PostagemClasse> retornaPostagens(){
        return this.postagemRepository.findAll();
    }
}
