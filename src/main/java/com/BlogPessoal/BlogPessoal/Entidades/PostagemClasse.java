package com.BlogPessoal.BlogPessoal.Entidades;

import com.BlogPessoal.BlogPessoal.DTO.PostagemDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_Postagem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="idPostagem")
public class PostagemClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostagem;

    private String tituloPostagem;

    private String categoriaPostagem;

    private String conteudoPostagem;

    public PostagemClasse(PostagemDTO postagemDTO){
        this.tituloPostagem = postagemDTO.tituloPostagem();
        this.categoriaPostagem = postagemDTO.categoriaClasse();
        this.conteudoPostagem = postagemDTO.conteudoPostagem();
    }
}