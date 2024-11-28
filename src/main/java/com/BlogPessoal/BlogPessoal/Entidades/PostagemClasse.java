package com.BlogPessoal.BlogPessoal.Entidades;

import com.BlogPessoal.BlogPessoal.DTO.PostagemDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "categoria_classe_id")
    private CategoriaClasse categoriaPostagem;

    private String conteudoPostagem;

    public PostagemClasse(PostagemDTO postagemDTO){
        this.tituloPostagem = postagemDTO.tituloPostagem();
        this.categoriaPostagem = postagemDTO.categoriaClasse();
        this.conteudoPostagem = postagemDTO.conteudoPostagem();
    }
}