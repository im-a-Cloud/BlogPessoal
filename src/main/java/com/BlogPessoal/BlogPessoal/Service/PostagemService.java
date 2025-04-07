package com.BlogPessoal.BlogPessoal.Service;

import com.BlogPessoal.BlogPessoal.DTO.PostagemDTO;
import com.BlogPessoal.BlogPessoal.Entidades.PostagemClasse;
import com.BlogPessoal.BlogPessoal.Entidades.UsuarioClasse;
import com.BlogPessoal.BlogPessoal.Repository.PostagemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
    public List<PostagemClasse> retornaPostagens(){
        return this.postagemRepository.findAll();
    }
    public PostagemClasse atualizarParcialmente(Long id, PostagemDTO atualizacao) {
        PostagemClasse postagem = postagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada"));

        // Copia apenas os valores não nulos do DTO para a entidade
        BeanUtils.copyProperties(atualizacao, postagem, getNullPropertyNames(atualizacao));

        return postagemRepository.save(postagem);
    }
    // Helper para encontrar propriedades nulas no DTO
    private String[] getNullPropertyNames(Object source) {
        return Arrays.stream(BeanUtils.getPropertyDescriptors(source.getClass()))
                .map(pd -> {
                    try {
                        Object value = pd.getReadMethod().invoke(source);
                        return value == null ? pd.getName() : null;
                    } catch (Exception e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .toArray(String[]::new);
    }
}
