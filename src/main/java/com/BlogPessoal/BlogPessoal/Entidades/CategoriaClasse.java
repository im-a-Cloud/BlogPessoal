package com.BlogPessoal.BlogPessoal.Entidades;

import com.BlogPessoal.BlogPessoal.DTO.CategoriaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_categoria_posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idCategoria") // Corrigido para idCategoria
public class CategoriaClasse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nomeCategoria;

    @ManyToOne
    @JoinTable(name = "postagem_id")
    private PostagemClasse postagemClasse;

    public CategoriaClasse(CategoriaDTO categoriaDTO){
        this.nomeCategoria = categoriaDTO.nomeCategoria();

    }
}
